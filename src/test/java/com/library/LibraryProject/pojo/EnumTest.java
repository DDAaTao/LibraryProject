package com.library.LibraryProject.pojo;

import com.library.LibraryProject.common.ResultCode;
import org.junit.Test;

public class EnumTest {
    @Test
    public void t1(){
        System.out.println(ResultCode.SUCCESS.getCode());
    }
}
