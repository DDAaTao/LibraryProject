package com.library.libraryproject.entity.enums;

import lombok.*;

/**
 * @author dcl
 * */

public enum SeatStatusType {
    /**
     * 分为两种状态，一种代表已有预约或者已占座（此时无法再进行预约和占座操作），另外一种代表暂无
     * */
    BOOKED("booked", "已占座"),
    FREE("free", "自由的");

    @Getter
    private String code;
    @Getter
    private String value;

    SeatStatusType(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
