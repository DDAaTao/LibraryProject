package com.library.libraryproject.entity.enums;

import lombok.Getter;

/**
 * @author dcl
 * */
public enum SeatStatus {
    /**
     * 表示占座的多种状态
     * */
    NORMAL("NORMAL", "正常"),
    LEAVE("LEAVE", "离开");

    @Getter
    private String code;
    @Getter
    private String name;
    SeatStatus(String code, String name){
        this.code = code;
        this.name = name;
    }
}
