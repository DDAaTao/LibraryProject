package com.library.libraryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author 文涛
 * @date 2018年9月14日00:01:30
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatStatus {
    private String seatId;
    private Date seatStart;
    private Date seatFinish;
    private Integer deleted;
}