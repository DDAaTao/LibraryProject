package com.library.libraryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author dcl
 * @date 2018年9月14日00:01:30
 *
 * TODO 暂时弃用，使用order进行替代
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
