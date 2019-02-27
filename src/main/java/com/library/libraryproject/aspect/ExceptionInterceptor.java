package com.library.libraryproject.aspect;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionInterceptor {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    AjaxResult handlerAllException(Exception e){
        log.error("=====统一异常拦截器=====", e);
        return AjaxResult.fail(ResultCode.SYSTEM_ERROR.getCode(), e.getMessage());
    }
}
