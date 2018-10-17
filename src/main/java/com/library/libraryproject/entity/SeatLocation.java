package com.library.libraryproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 文涛
 * @date 2018年9月14日00:01:30
 * */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SeatLocation {
    private String seatId;
    private String seatArea;
    private String seatStorey;
    private String seatRoom;
    private String seatNumber;
    private Integer deleted;
}
