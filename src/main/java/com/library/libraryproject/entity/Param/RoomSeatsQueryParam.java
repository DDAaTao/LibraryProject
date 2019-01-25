package com.library.libraryproject.entity.Param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author dcl
 * */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomSeatsQueryParam {
    /**
     * 校区
     * */
    private String seatArea;
    /**
     * 建筑
     * */
    private String seatBuilding;
    /**
     * 楼层
     * */
    private String seatStorey;
    /**
     * 自习室
     * */
    private String seatRoom;
}
