package com.library.libraryproject.entity.enums;

/**
 * @author dcl
 * */
public enum SeatStatus {
    NORMAL("NORMAL", "正常"),
    LEAVE("LEAVE", "离开");

    private String code;
    private String name;
    SeatStatus(String code, String name){
        this.code = code;
        this.name = name;
    }
}
