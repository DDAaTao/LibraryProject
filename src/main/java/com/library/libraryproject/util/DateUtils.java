package com.library.libraryproject.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
/**
 * @author dcl
 * 自定义时间工具类
 * */
public class DateUtils {
    public static Date now() {
        return Date.from(Instant.now());
    }

    /**
     * 判断两个时间如果再同一天的话，前者是否大于后者
     * */
    public static Boolean sameDayCompare(Date dateOne, Date dateTwo){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String formatOne = simpleDateFormat.format(dateOne);
        String formatTwo = simpleDateFormat.format(dateTwo);
        try {
            if (simpleDateFormat.parse(formatOne).getTime() > simpleDateFormat.parse(formatTwo).getTime()){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取格式化时间
     * */
    public static Date getFormatDate(String date, String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date parse = simpleDateFormat.parse(date);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某天的起始时间
     * */
    public static Date getDayStartTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某天的结束时间
     * */
    public static Date getDayEndTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 时间增加指定的天数
     * */
    public static Date addDays(Date date, Integer days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
}
