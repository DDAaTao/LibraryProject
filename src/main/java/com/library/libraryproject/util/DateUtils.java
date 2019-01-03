package com.library.libraryproject.util;

import java.time.Instant;
import java.util.Date;
/**
 * @author dcl
 * 自定义时间工具类
 * */
public class DateUtils {
    public static Date now() {
        return Date.from(Instant.now());
    }
}
