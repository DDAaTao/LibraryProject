package com.library.LibraryProject.utils;

public class StringUtil {

    public static boolean isNotNullOrEmpty(String str){
        return !(str == null || str.isEmpty());
    }

    public static boolean isNullOrEmpty(String str){
        return (str == null || str.isEmpty());
    }
}
