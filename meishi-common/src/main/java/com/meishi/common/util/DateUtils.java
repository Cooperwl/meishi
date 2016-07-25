/**
 * @Title: DateUtils.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 * YWX CONFIDENTIAL AND TRADE SECRET
 * @author:
 * @data:
 */
package com.meishi.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author WangLiang
 * @version1.0
 */

public final class DateUtils {
    private static Logger log = LoggerFactory.getLogger(DateUtils.class);
    /**
     * 如：2010-12-01
     */

    public static String FORMAT_SHORT = "yyyy-MM-dd";

    /**
     * 如：20101201
     */

    public static String FORMAT_SIMPLE = "yyyyMMdd";

    /**
     * 如：2010-12-01 23:15:06
     */

    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";


    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */

    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 中文简写 如：2010年12月01日
     */

    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";

    /**
     * 精确到毫秒的完整中文时间
     */

    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    /**
     * 获得默认的 date pattern
     */

    public static String getDatePattern() {

        return FORMAT_LONG;

    }

    /**
     * <p>
     * 功能描述:[方法功能中文描述]
     * </p>
     *
     * @return
     * @author: WangLiang
     * @update:[2014年12月12日 下午4:57:52] WangLiang [变更描述]
     */
    public static Date getDate() {
        return parse(getNow());
    }

    public static Date getDate(String format) {
        return parse(getNow(), format);
    }

    /**
     * 根据预设格式返回当前日期
     *
     * @return
     */

    public static String getNow() {

        return format(new Date());

    }

    /**
     * 根据用户格式返回当前日期
     *
     * @param format
     * @return
     */

    public static String getNow(String format) {

        return format(new Date(), format);

    }

    /**
     * 使用预设格式格式化日期
     *
     * @param date
     * @return
     */

    public static String format(Date date) {

        return format(date, getDatePattern());

    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     */

    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }

        return (returnValue);

    }

    /**
     * 使用预设格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @return
     */

    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */

    public static Date parse(String strDate, String pattern) {
        if (StringUtils.isNullOrEmpty(strDate)) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            log.error("parse date error. date: " + strDate + " pattern:" + pattern);
            return null;
        }

    }

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return
     */

    public static Date addMonth(Date date, int n) {

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        cal.add(Calendar.MONTH, n);

        return cal.getTime();

    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    要增加的天数
     * @return
     */

    public static Date addDay(Date date, int n) {

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        cal.add(Calendar.DATE, n);

        return cal.getTime();

    }

    /**
     * 在当前日期上添加小时数
     *
     * @param date
     * @param hour
     * @return
     */
    public static Date addHour(Date date, Double hour) {
        Long time = date.getTime();
        Double times = time + hour * 60 * 60 * 1000;
        return new Date(Math.round(times));
    }

    /**
     * 获取日期年份
     *
     * @param date 日期
     * @return
     */

    public static String getYear(Date date) {

        return format(date).substring(0, 4);

    }

    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return
     */

    public static int countDays(String date) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date));
        long t1 = c.getTime().getTime();
        return (int) ((t / 1000 - t1 / 1000) / 3600 / 24);
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date   日期字符串
     * @param format 日期格式
     * @return
     */
    public static int countDays(String date, String format) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, format));
        long t1 = c.getTime().getTime();
        return (int) ((t / 1000 - t1 / 1000) / 3600 / 24);

    }

    /**
     * 计算两个日期的间隔天数
     *
     * @return
     */
    public static int countDays(Date start, Date end) {
        long t1 = start.getTime();
        long t2 = end.getTime();
        return (int) ((t2 / 1000 - t1 / 1000) / 3600 / 24);
    }

    /**
     * @param start
     * @param end
     * @return
     * @Description: 计算两个日期的月份数
     * @throws:
     * @author: lz
     * @update:[2015年5月21日 上午10:55:59] lz 变更描述
     */
    public static int countMonth(String start, String end) {
        int month = 0;
        int year = 0;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(parse(start));
        cal2.setTime(parse(end));
        if (cal1.after(cal2)) {
            Calendar temp = cal1;
            cal1 = cal2;
            cal2 = temp;
        }
        year = Math.abs(cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR));
        month = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);

        return year * 12 + month;
    }

    /**
     * @param start
     * @param end
     * @return
     * @Description: 忽略年份和月份，只计算天数
     * @throws:
     * @author: lz
     * @update:[2015年5月21日 上午10:56:34] lz 变更描述
     */
    public static int countDaysIngoreMonthAndYear(String start, String end) {
        int result = 0;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(DateUtils.parse(start));
        cal2.setTime(DateUtils.parse(end));
        result = cal2.get(Calendar.DATE) - cal1.get(Calendar.DATE);
        return result;
    }

    /**
     * @param start  开始日期
     * @param end    结束日期
     * @param isCeil 是否向上取整
     * @return
     * @Description: 计算两个日期间隔天数
     * @throws:
     * @author: WangLiang
     * @update:[2015年4月15日 下午2:45:19] WangLiang 变更描述
     */
    public static int countDays(Date start, Date end, boolean isCeil) {
        if (!isCeil) {//不满一天则不计算在内
            return countDays(start, end);
        }
        int mins = countMins(start, end);
        double hours = mins / 60.0 / 24;//算出double类型的小时数
        int intHours = (int) hours;
        if (hours > intHours) {
            intHours++;
        }
        return intHours;
    }

    /**
     * 计算间隔小时数  -带半小时(不足半小时按照半小时 超过半小时按照一个小时算)
     *
     * @return
     */
    public static double countHour(Date start, Date end) {
        long t1 = start.getTime();
        long t2 = end.getTime();
        int hour = (int) ((t2 / 1000 - t1 / 1000) / 3600);
        double halfHour = 0;
        if ((countMins(start, end) - hour * 60) > 30) {
            halfHour = 1;
        } else if ((countMins(start, end) - hour * 60) <= 30 && (countMins(start, end) - hour * 60) > 0) {
            halfHour = 0.5;
        }
        return hour + halfHour;
    }

    /**
     * 计算两个日期的间隔分钟数
     *
     * @return
     */
    public static int countMins(Date start, Date end) {
        long t1 = start.getTime();
        long t2 = end.getTime();

        return (int) ((t2 - t1) / 1000 / 60);
    }

    /**
     * @param startDate
     * @param enDate
     * @return
     * @Description: 判断是否超过一个月
     * @throws:
     * @author: kui
     * @update:[2015年3月30日 上午10:45:53] kui 变更描述
     */
    public static boolean isMoreThenMonth(Date startDate, Date enDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.MONTH, 1);
        if (enDate.getTime() - c.getTimeInMillis() >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
