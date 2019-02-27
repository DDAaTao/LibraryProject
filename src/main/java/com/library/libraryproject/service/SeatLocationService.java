package com.library.libraryproject.service;

import java.util.List;

import com.library.libraryproject.entity.Param.RoomSeatsQueryParam;
import com.library.libraryproject.entity.SeatLocation;
public interface SeatLocationService{

    int insert(SeatLocation seatLocation);

    int insertSelective(SeatLocation seatLocation);

    int insertList(List<SeatLocation> seatLocations);

    int update(SeatLocation seatLocation);

    /**
     * 获取所有座位信息
     * */
    List<SeatLocation> getRoomSeats(String roomId);

    /**
     * 删除座位（逻辑删除）
     * */
    int deleteSeat(String seatId);

    /**
     * 删除座位（物理删除）
     * */
    int realDeleteSeat(String seatId);

    /**
     * 恢复逻辑删除的座位接口
     * */
    int recoverSeat(String seatId);

}
