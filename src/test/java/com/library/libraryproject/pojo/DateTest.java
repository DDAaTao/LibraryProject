package com.library.libraryproject.pojo;

import com.library.libraryproject.util.DateUtils;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date now = DateUtils.now();
        System.out.println(now);
        System.out.println(now.getTime());
        System.out.println(now.getTime()-1);
        System.out.println(new Date(now.getTime()-1000));
    }
}
