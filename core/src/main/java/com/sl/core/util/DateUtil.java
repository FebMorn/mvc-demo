package com.sl.core.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.*;

public class DateUtil{

    /**
     * 判断两个日期时间是否是同一天
     */
    public static boolean isSameDay(Date date1, Date date2) {
        return DateUtils.isSameDay(date1,date2);
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        return DateUtils.isSameDay(cal1,cal2);
    }

    /**
     * 判断两个日期是否相同
     * 这种方法比较两个对象的毫秒时间
     */
    public static boolean isSameInstant(Date date1, Date date2) {
        return DateUtils.isSameInstant(date1,date2);
    }

    public static boolean isSameInstant(Calendar cal1, Calendar cal2) {
        return DateUtils.isSameInstant(cal1,cal2);
    }

    /**
     * 判断两个日历本地时间是否相同
     * 除了比较数值外两个日历对象的类型还要相同 --> cal1.getClass() == cal2.getClass()
     */
    public static boolean isSameLocalTime(Calendar cal1, Calendar cal2) {
        return DateUtils.isSameLocalTime(cal1,cal2);
    }

    /**
     * 尝试用parsePatterns中各种不同的日期格式解析代表时间的字符串str 。
     * 解析时会逐个使用parsePatterns中的格式，如果都没有匹配上， 则抛出异常ParseException 。
     */
    public static Date parseDate(String str, String... parsePatterns) throws ParseException {
        return DateUtils.parseDate(str,parsePatterns);
    }

    public static Date parseDate(String str, Locale locale, String... parsePatterns) throws ParseException {
        return DateUtils.parseDate(str,locale,parsePatterns);
    }

    /**
     * 尝试用parsePatterns中各种不同的日期格式解析代表时间的字符串str 。
     * 解析时会逐个使用parsePatterns中的格式，如果都没有匹配上， 则抛出异常ParseException 。
     * 解析器解析严格不允许的日期， 如："February 942, 1996" 。
     */
    public static Date parseDateStrictly(String str, String... parsePatterns) throws ParseException {
        return DateUtils.parseDateStrictly(str, parsePatterns);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... parsePatterns) throws ParseException {
        return DateUtils.parseDateStrictly(str,locale,parsePatterns);
    }

    /**
     * 给日期data设置一个新的时间
     */
    public static Date addYears(Date date, int amount) {
        return DateUtils.addYears(date,amount);
    }

    public static Date addMonths(Date date, int amount) {
        return DateUtils.addMonths(date,amount);
    }

    public static Date addWeeks(Date date, int amount) {
        return DateUtils.addWeeks(date,amount);
    }

    public static Date addDays(Date date, int amount) {
        return DateUtils.addDays(date,amount);
    }

    public static Date addHours(Date date, int amount) {
        return DateUtils.addHours(date,amount);
    }

    public static Date addMinutes(Date date, int amount) {
        return DateUtils.addMonths(date,amount);
    }

    public static Date addSeconds(Date date, int amount) {
        return DateUtils.addSeconds(date,amount);
    }

    public static Date addMilliseconds(Date date, int amount) {
        return DateUtils.addMilliseconds(date,amount);
    }

    public static Date setYears(Date date, int amount) {
        return DateUtils.setYears(date,amount);
    }

    public static Date setMonths(Date date, int amount) {
        return DateUtils.setMonths(date,amount);
    }

    public static Date setDays(Date date, int amount) {
        return DateUtils.setDays(date,amount);
    }

    public static Date setHours(Date date, int amount) {
        return DateUtils.setHours(date,amount);
    }

    public static Date setMinutes(Date date, int amount) {
        return DateUtils.setMinutes(date,amount);
    }

    public static Date setSeconds(Date date, int amount) {
        return DateUtils.setSeconds(date,amount);
    }

    public static Date setMilliseconds(Date date, int amount) {
        return DateUtils.setMilliseconds(date,amount);
    }

    public static Calendar toCalendar(Date date) {
        return DateUtils.toCalendar(date);
    }

    public static Calendar toCalendar(Date date, TimeZone tz) {
        return DateUtils.toCalendar(date,tz);
    }

    /**
     * 根据阈值field四舍五入日期
     * 例如， 如果你的时间是 28 Mar 2002 13:45:01.231，
     * 如果field为HOUR，它将返回 28 Mar 2002 14:00:00.000；
     * 如果field为MONTH，它将返回 1 April 2002 0:00:00.000 。
     */
    public static Date round(Date date, int field) {
        return DateUtils.round(date,field);
    }

    public static Calendar round(Calendar date, int field) {
        return DateUtils.round(date,field);
    }

    public static Date round(Object date, int field) {
        return DateUtils.round(date,field);
    }

    /**
     * 根据阈值field截取日期date 。
     * 例如， 如果你的时间是 28 Mar 2002 13:45:01.231，
     * 如果field为HOUR，它将返回 28 Mar 2002 13:00:00.000；
     * 如果field为MONTH，它将返回 1 Mar 2002 0:00:00.000 。
     */
    public static Date truncate(Date date, int field) {
        return DateUtils.truncate(date,field);
    }

    public static Calendar truncate(Calendar date, int field) {
        return DateUtils.truncate(date,field);
    }

    public static Date truncate(Object date, int field) {
        return DateUtils.truncate(date,field);
    }

    /**
     * 根据阈值field向上舍入日期date 。
     * 例如， 如果你的时间是 28 Mar 2002 13:45:01.231，
     * 如果field为HOUR，它将返回 28 Mar 2002 14:00:00.000；
     * 如果field为MONTH，它将返回 1 Apr 2002 0:00:00.000 。
     */
    public static Date ceiling(Date date, int field) {
        return DateUtils.ceiling(date,field);
    }

    public static Calendar ceiling(Calendar date, int field) {
        return DateUtils.ceiling(date,field);
    }

    public static Date ceiling(Object date, int field) {
        return DateUtils.ceiling(date,field);
    }

    /**
     * 根据指定的时间focus和范围类型rangeStyle构建一个时间范围迭代器 。
     * 如传入的时间是Thursday, July 4, 2002，范围类型是RANGE_MONTH_SUNDAY，
     * 则返回迭代器的范围是从Sunday, June 30, 2002 到 Saturday, August 3, 2002
     * @param rangeStyle  范围类型，值必须是如下之一：
     * DateUtils.RANGE_MONTH_SUNDAY，
     * DateUtils.RANGE_MONTH_MONDAY，
     * DateUtils.RANGE_WEEK_SUNDAY，
     * DateUtils.RANGE_WEEK_MONDAY，
     * DateUtils.RANGE_WEEK_RELATIVE，
     * DateUtils.RANGE_WEEK_CENTER
     */
    public static Iterator<Calendar> iterator(Date focus, int rangeStyle) {
        return DateUtils.iterator(focus,rangeStyle);
    }

    public static Iterator<Calendar> iterator(Calendar focus, int rangeStyle) {
        return DateUtils.iterator(focus,rangeStyle);
    }

    public static Iterator<?> iterator(Object focus, int rangeStyle) {
        return DateUtils.iterator(focus,rangeStyle);
    }

    /**
     * 返回指定分段内的毫秒数/秒数/分钟/小时/天数 。 所有大于分段的DateFields将被忽略 。
     *
     * 以毫秒为例：
     * 请求任何日期毫秒，将返回当前秒的毫秒数 (返回一个数字在0和999之间) 。
     * 有效的分段值是： Calendar.YEAR、Calendar.MONTH、Calendar.DAY_OF_YEAR、
     * Calendar.DATE、Calendar.HOUR_OF_DAY、Calendar.MINUTE、
     * Calendar.SECOND 和 Calendar.MILLISECOND
     * 分段值小于或等于MILLISECOND，将返回0 。
     *
     *  January 1, 2008 7:15:10.538 with Calendar.SECOND as fragment will return 538
     *  January 6, 2008 7:15:10.538 with Calendar.SECOND as fragment will return 538
     *  January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return 10538
     *  January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in milliseconds)
     */
    public static long getFragmentInMilliseconds(Date date, int fragment) {
        return DateUtils.getFragmentInMilliseconds(date,fragment);
    }


    public static long getFragmentInSeconds(Date date, int fragment) {
        return DateUtils.getFragmentInSeconds(date,fragment);
    }

    public static long getFragmentInMinutes(Date date, int fragment) {
        return DateUtils.getFragmentInMinutes(date,fragment);
    }

    public static long getFragmentInHours(Date date, int fragment) {
        return DateUtils.getFragmentInHours(date,fragment);
    }

    public static long getFragmentInDays(Date date, int fragment) {
        return DateUtils.getFragmentInDays(date,fragment);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int fragment) {
        return DateUtils.getFragmentInMilliseconds(calendar,fragment);
    }

    public static long getFragmentInSeconds(Calendar calendar, int fragment) {
        return DateUtils.getFragmentInSeconds(calendar,fragment);
    }

    public static long getFragmentInMinutes(Calendar calendar, int fragment) {
        return DateUtils.getFragmentInMinutes(calendar,fragment);
    }

    public static long getFragmentInHours(Calendar calendar, int fragment) {
        return DateUtils.getFragmentInHours(calendar,fragment);
    }

    public static long getFragmentInDays(Calendar calendar, int fragment) {
        return DateUtils.getFragmentInDays(calendar,fragment);
    }

    /**
     * 截取比较两个日历对象的field处的值是否相同 。
     */
    public static boolean truncatedEquals(Calendar cal1, Calendar cal2, int field) {
        return DateUtils.truncatedEquals(cal1,cal2,field);
    }

    public static boolean truncatedEquals(Date date1, Date date2, int field) {
        return DateUtils.truncatedEquals(date1,date2,field);
    }

    /**
     * 截取比较两个日历对象的field处的值 。
     * 如果第一个日历小于、等于、大于第二个，则对应返回负整数、0、正整数
     */
    public static int truncatedCompareTo(Calendar cal1, Calendar cal2, int field) {
        return DateUtils.truncatedCompareTo(cal1,cal2,field);
    }

    public static int truncatedCompareTo(Date date1, Date date2, int field) {
        return DateUtils.truncatedCompareTo(date1,date2,field);
    }

    /**
     * 格式化输出时间
     */
    public static String formatUTC(long millis, String pattern) {
        return DateFormatUtils.formatUTC(millis,pattern);
    }

    public static String formatUTC(Date date, String pattern) {
        return DateFormatUtils.formatUTC(date,pattern);
    }

    public static String formatUTC(long millis, String pattern, Locale locale) {
        return DateFormatUtils.formatUTC(millis,pattern,locale);
    }

    public static String formatUTC(Date date, String pattern, Locale locale) {
        return DateFormatUtils.formatUTC(date,pattern,locale);
    }

    public static String format(long millis, String pattern) {
        return DateFormatUtils.format(millis,pattern);
    }

    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date,pattern);
    }

    public static String format(Calendar calendar, String pattern) {
        return DateFormatUtils.format(calendar,pattern);
    }

    public static String format(long millis, String pattern, TimeZone timeZone) {
        return DateFormatUtils.format(millis,pattern,timeZone);
    }

    public static String format(Date date, String pattern, TimeZone timeZone) {
        return DateFormatUtils.format(date,pattern,timeZone);
    }

    public static String format(Calendar calendar, String pattern, TimeZone timeZone) {
        return DateFormatUtils.format(calendar,pattern,timeZone);
    }

    public static String format(long millis, String pattern, Locale locale) {
        return DateFormatUtils.format(millis,pattern,locale);
    }

    public static String format(Date date, String pattern, Locale locale) {
        return DateFormatUtils.format(date,pattern,locale);
    }

    public static String format(Calendar calendar, String pattern, Locale locale) {
        return DateFormatUtils.format(calendar,pattern,locale);
    }

    public static String format(long millis, String pattern, TimeZone timeZone, Locale locale) {
        return DateFormatUtils.format(millis,pattern,timeZone,locale);
    }

    public static String format(Date date, String pattern, TimeZone timeZone, Locale locale) {
        return DateFormatUtils.format(date,pattern,timeZone,locale);
    }

    public static String format(Calendar calendar, String pattern, TimeZone timeZone, Locale locale) {
        return DateFormatUtils.format(calendar,pattern,timeZone,locale);
    }

}
