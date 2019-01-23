package com.library.libraryproject.entity.vo;

import lombok.*;

/**
 * @author dcl
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomSeatAndStatusVO {
    private String seatId;
    private String seatArea;
    private String seatBuilding;
    private String seatStorey;
    private String seatRoom;
    private String seatNumber;
    private String seatStatus;
}
