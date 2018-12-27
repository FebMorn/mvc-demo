package com.sl.core.util;

import java.math.BigDecimal;

public class NumberFormatUtil {
    //简体中文数字
    private static final String[] NUMBER_ZH_SIMPLIFIED = {"零","一","二","三","四","五","六","七","八","九","十"};
    private static final String[] UNIT_SIMPLIFIED = {"","十","百","千","万","十","百","千","亿"};


    //繁体中文数字
    private static final String[] NUMBER_ZH_TRADITIONAL  = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖","拾"};
    private static final String[] UNIT_TRADITIONAL  = {"","拾","佰","仟","萬","拾","佰","仟","亿"};

    /**
     * 获取数字的简体中文
     * @param value
     * @return
     */
    public static String toZhSimplified(String value){
        return numberToZh(value,1);
    }


    /**
     * 获取数字的繁体中文
     * @param value
     * @return
     */
    public static String toZhTraditional(String value){
        return numberToZh(value,2);
    }

    /**
     *
     * @param value 传入数字字符串
     * @param flg 1简体 2繁体
     * @return
     */
    private static String numberToZh(String value, int flg){
        String[] numberZhArr = flg==2?NUMBER_ZH_TRADITIONAL:NUMBER_ZH_SIMPLIFIED;
        String[] unitArr = flg==2?UNIT_TRADITIONAL:UNIT_SIMPLIFIED;

        String doubleVal;
        try {
            doubleVal = new BigDecimal(value).toPlainString();
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException("仅支持整数或浮点数");
        }
        StringBuffer zhStr = new StringBuffer();
        int index = doubleVal.indexOf(".");
        //System.out.println(doubleVal);
        //拼接整数部分
        int integerLength = index<0?doubleVal.length():index;
        //是否需要零
        boolean need0 = false;
        for (int i=0; i<integerLength; i++){
            try {
                int intVal = Integer.parseInt(String.valueOf(doubleVal.charAt(i)));
                if (intVal != 0){
                    if(i==0 && (integerLength-1)%4==1 && intVal==1){
                        zhStr.append(getUnit(unitArr,integerLength-1-i));
                        continue;
                    }
                    if(need0){
                        zhStr.append(numberZhArr[0]);
                    }
                    zhStr.append(numberZhArr[intVal]);
                    zhStr.append(getUnit(unitArr,integerLength-1-i));
                    need0 = false;
                }else if((integerLength-1-i)%4==0){
                    zhStr.append(getUnit(unitArr,integerLength-1-i));
                    need0 = false;
                }else{
                    need0 = true;
                }
            }catch (Exception ex){
                zhStr.append("?");
                zhStr.append(getUnit(unitArr,integerLength-1-i));
                need0 = false;
            }
        }

        //拼接小数部分
        if(index>=0 && index<doubleVal.length()){
            zhStr.append("点");
            for (int i=index+1; i<doubleVal.length(); i++){
                try {
                    int intVal = Integer.parseInt(String.valueOf(doubleVal.charAt(i)));
                    zhStr.append(numberZhArr[intVal]);
                }catch (Exception ex){
                    zhStr.append("?");
                }
            }
        }
        return zhStr.toString();
    }


    /**
     * 获取某一位的单位
     * @param unitArr 单位数组
     * @param unitOrder 位数
     * @return
     */
    private static String getUnit(String[] unitArr, int unitOrder){
        if (unitOrder<0 || unitArr==null){
            return "";
        }
        int index = unitOrder%8;
        if(index != 0){
            return unitArr[index];
        }else if(unitOrder>0){
            return unitArr[8];
        }else{
            return unitArr[0];
        }
    }

//    public static void main(String[] args) throws Exception {
//
//
//        double a = 1110011010.34;
//
//        System.out.println(toZhSimplified(String.valueOf(a)));
//        System.out.println(toZhTraditional(String.valueOf(a)));
//    }
}
