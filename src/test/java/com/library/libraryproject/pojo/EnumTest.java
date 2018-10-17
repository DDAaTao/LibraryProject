package com.library.libraryproject.pojo;

import com.library.libraryproject.common.ResultCode;
import org.junit.Test;

public class EnumTest {
    @Test
    public void t1(){
        System.out.println(ResultCode.SUCCESS.getCode());
    }
}
