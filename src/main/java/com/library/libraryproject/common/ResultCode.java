package com.library.libraryproject.common;



/**
 * @author dcl
 * */
public enum ResultCode {
    /**
     * result success
     * */
    SUCCESS("200", "success"),

    /**
     * drop something fail
     * */
    DROP_FAIL("drop.fail", "删除操作失败"),

    /**
     * drop manager fail
     * */
    DROP_MANAGER_FAIL("drop.manager.fail", "删除管理员失败"),

    /**
     * every fail download fail
     * */
    DOWNLOAD_FAIL("download.fail", "下载失败"),

    /**
     * every fail upload fail
     * */
    UPLOAD_FAIL("upload.fail", "上传失败"),

    /**
     * result fail
     * */
    FAIL("500", "fail"),
    ORDER_FAIL("order.fail", "占座失败"),
    PARAM_ERROR("param.error", "参数校验失败"),
    ORDER_TIME_ERROR("order.time.error", "预约的相关时间选择有误");

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
