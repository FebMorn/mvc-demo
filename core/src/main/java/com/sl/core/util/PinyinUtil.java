package com.sl.core.util;

import com.google.common.base.Joiner;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.List;

public class PinyinUtil {

    /**
     * 获得汉语拼音首字母，其他字符不变，最后全部转换成小写
     *
     * @param chines 汉字
     * @return
     */
    public static String getAlpha(String chines) {
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            pinyinName += getPinYin(nameChar[i],defaultFormat)[0].charAt(0);
        }
        return pinyinName.toLowerCase();
    }

    /**
     * 将字符串中的中文转化为拼音,英文字符不变，最后全部转换成小写
     *
     * @param inputString 汉字
     * @return
     */
    public static String getPingYin(String inputString) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String output = "";
        char[] input = inputString.trim().toCharArray();
        for (int i = 0; i < input.length; i++) {
            output += getPinYin(input[i],format)[0];
        }
        return output.toLowerCase();
    }

    /**
     * 获得汉语拼音首字母的所有组合 以英文,分割
     *
     * @param chines 汉字
     * @return
     */
    public static String getAlphaAll(String chines) {
        char[] nameChar = chines.toCharArray();
        String[][] pinYinArr = new String[nameChar.length][];
        int size = 1;

        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        //开始获取每个字符的音标
        for (int i = 0; i < nameChar.length; i++) {
            pinYinArr[i] = getPinYinWithoutRepeat(nameChar[i],defaultFormat);
            size = size*pinYinArr[i].length;
        }

        //对每个字符的音标进行整理
        List<String> all = methodAlpha(pinYinArr,pinYinArr.length-1,new ArrayList<>(size));
        return Joiner.on(",").join(all).toLowerCase();
    }

    public static String getPingYinAll(String chines) {
        char[] nameChar = chines.toCharArray();
        String[][] pinYinArr = new String[nameChar.length][];
        int size = 1;

        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        //开始获取每个字符的音标
        for (int i = 0; i < nameChar.length; i++) {
            pinYinArr[i] = getPinYinWithoutRepeat(nameChar[i],defaultFormat);
            size = size*pinYinArr[i].length;
        }

        //对每个字符的音标进行整理
        List<String> all = methodPinYin(pinYinArr,pinYinArr.length-1,new ArrayList<>(size));
        return Joiner.on(",").join(all).toLowerCase();
    }

    public static String getAll(String chines) {
        char[] nameChar = chines.toCharArray();
        String[][] pinYinArr = new String[nameChar.length][];
        int size = 1;

        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        //开始获取每个字符的音标
        for (int i = 0; i < nameChar.length; i++) {
            pinYinArr[i] = getPinYinWithoutRepeat(nameChar[i],defaultFormat);//去重了比不去重要快一点
            size = size*pinYinArr[i].length;
        }

        //对每个字符的音标进行整理
        List<String> allAlpha = methodAlpha(pinYinArr,pinYinArr.length-1,new ArrayList<>(size));
        List<String> allPinYin = methodPinYin(pinYinArr,pinYinArr.length-1,new ArrayList<>(size));
        return (Joiner.on(",").join(allAlpha)+","+Joiner.on(",").join(allPinYin)).toLowerCase();
    }


    /**
     * list方法
     * @param para 要处理的数组
     * @param index para的索引号
     * @param container 返回的对象
     * @return
     */
    private static List<String> methodAlpha(String[][] para,int index,List<String> container){
        if(index>0){
            List<String> list = methodAlpha(para,index-1,container);
            int size = list.size();
            for(int j=para[index].length-1; j>=0; j--){
                if(para[index][j] != null){
                    if (j==0){
                        for (int i=0; i<size; i++){
                            list.set(i,list.get(i)+para[index][j].charAt(0));
                        }
                    }else{
                        for (int i=0; i<size; i++){
                            list.add(list.get(i)+para[index][j].charAt(0));
                        }
                    }
                }
            }
            return list;
        }else{
            for (String s : para[index]){
                if(s != null){
                    container.add(String.valueOf(s.charAt(0)));
                }

            }
            return container;
        }
    }
    private static List<String> methodPinYin(String[][] para,int index,List<String> container){
        if(index>0){
            List<String> list = methodPinYin(para,index-1,container);
            int size = list.size();
            for(int j=para[index].length-1; j>=0; j--){
                if(para[index][j] != null){
                    if (j==0){
                        for (int i=0; i<size; i++){
                            list.set(i,list.get(i)+para[index][j]);
                        }
                    }else{
                        for (int i=0; i<size; i++){
                            list.add(list.get(i)+para[index][j]);
                        }
                    }
                }
            }
            return list;
        }else{
            for (String s : para[index]){
                if(s != null){
                    container.add(s);
                }

            }
            return container;
        }
    }

    /**
     * 数组方法
     * @return
     */
    private static String[] methodAlpha(String[][] para,int index,String[] container){
        return null;
    }


    public static String[] getPinYinWithoutRepeat(char c,HanyuPinyinOutputFormat defaultFormat){

        if (Character.toString(c).matches(
                "[\\u4E00-\\u9FA5]+")) {
            try {
                String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
                for (int i=pinYins.length-1; i>=0; i--){
                    if(pinYins[i] == null){
                        continue;
                    }
                    for(int j=0; j<i; j++){
                        if (pinYins[i].equals(pinYins[j])){
                            pinYins[i] = null;
                            break;
                        }
                    }
                }
                return pinYins;
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
                return new String[0];
            }
        } else {
            return new String[]{String.valueOf(c)};
        }
    }

    public static String[] getPinYin(char c,HanyuPinyinOutputFormat defaultFormat){

        if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
            try {
                String[] pinYins = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
                return pinYins;
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
                return new String[0];
            }
        } else {
            return new String[]{String.valueOf(c)};
        }
    }



//    public static void main(String[] args) throws Exception {
//        System.out.println(getAlphaAll("不行"));
//        System.out.println(getPingYinAll("不行"));
//        System.out.println(getAlphaAll("不行"));
//
//
//
//
//
//
////        char[] c = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n'};
//////        System.out.println(c.length);
////        Random r = new Random();
//////        System.out.println(r.nextInt(13));
////        long i1 = System.currentTimeMillis();
////        for (int i=0; i<10000000; i++){
////            String a = String.valueOf(c[r.nextInt(13)]);
////
////        }
////        System.out.println(System.currentTimeMillis()-i1);
//
//
//
//        long i1 = System.currentTimeMillis();
//        for (int i=0 ; i<30000; i++){
//            getAlphaAll("不行会校");
//            getAlphaAll("参差");
//
//        }
//        System.out.println(System.currentTimeMillis()-i1);
//
//
//
//
//
//
//
//    }
}
