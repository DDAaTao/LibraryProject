package com.library.libraryproject.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author dcl
 * @date 2018年10月8日22:13:43
 *
 * 定义统一的返回格式
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult<T> {
    private String code;
    private String message;
    private String requestId;
    private T data;

    public static AjaxResult success(){
        return AjaxResult.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMsg())
                .build();
    }

    public static <T> AjaxResult success(T data){
        return AjaxResult.builder()
                .code(ResultCode.SUCCESS.getCode())
                .data(data)
                .message(ResultCode.SUCCESS.getMsg())
                .build();
    }

    public static AjaxResult fail(String code, String msg){
        return AjaxResult.builder()
                .code(code)
                .message(msg)
                .build();
    }

}
