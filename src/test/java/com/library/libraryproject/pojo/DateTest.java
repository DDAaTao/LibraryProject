package com.library.libraryproject.pojo;

import com.library.libraryproject.util.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date now = DateUtils.now();
        System.out.println(now);
        System.out.println(now.getTime());
        System.out.println(now.getTime()-1);
        System.out.println(new Date(now.getTime()-1000));
    }

    @Test
    public void testGetHours(){
        // todo 先转化为小时纬度点字符串，然后再让字符串转化为今天点时间，然后再进行比较
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        try {
            Date date = simpleDateFormat.parse("18:00:00");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
