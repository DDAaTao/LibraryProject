package com.library.LibraryProject.common;


import javax.security.auth.login.FailedLoginException;

/**
 * @author 文涛
 * */
public enum ResultCode {
    /**
     * result success
     * */
    SUCCESS("200","success"),

    /**
     * drop manager fail
     * */
    DROP_MANAGER_FAIL("drop.manager.fail","删除管理员失败"),

    /**
     * download all user fail
     * */
    DOWNLOAD_FAIL("download.fail","下载失败"),
    /**
     * result fail
     * */
    FAIL("500","fail");

    private String code;
    private String msg;
    /**
     * constructor
     * */
    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultCode getEnum(String id){
        for (ResultCode num : ResultCode.values()){
            if (num.code.equals(id)){
                return num;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
