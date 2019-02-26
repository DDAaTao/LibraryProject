package com.library.libraryproject.common;



/**
 * @author dcl
 * 返回代号
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
    ORDER_TIME_ERROR("order.time.error", "预约的相关时间选择有误"),
    ADD_USER_ERROR("add.user.error", "新增用户失败"),
    FINISH_ORDER_FAIL("finish.order.fail", "结束占座失败"),
    USER_LOGIN_ERROR("user.login.error", "用户登陆失败"),
    DELETE_SEAT_ERROR("delete.seat.error", "删除座位失败"),
    RECOVER_SEAT_ERROR("recover.seat.error", "恢复座位失败"),



    SYSTEM_ERROR("system.error", "系统异常")
    ;

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
