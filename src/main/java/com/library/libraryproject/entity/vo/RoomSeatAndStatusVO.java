package com.library.libraryproject.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dcl
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomSeatAndStatusVO {
    private String seatId;
    private String seatArea;
    private String seatBuilding;
    private String seatStorey;
    private String seatRoom;
    private String seatNumber;
    private String seatStatus;
}
