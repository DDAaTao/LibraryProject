package com.library.libraryproject.entity.enums;

import lombok.Getter;

/**
 * @author dcl
 * */
public enum OrderStatus {
    /**
     * 表示占座的多种状态
     * */
    NORMAL("normal", "正常"),
    LEAVE("leave", "离开");

    @Getter
    private String code;
    @Getter
    private String name;
    OrderStatus(String code, String name){
        this.code = code;
        this.name = name;
    }
}
