package com.library.libraryproject.service.impl;

import com.library.libraryproject.entity.Param.RoomSeatsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.library.libraryproject.entity.SeatLocation;
import com.library.libraryproject.dao.SeatLocationDao;
import com.library.libraryproject.service.SeatLocationService;

@Service
public class SeatLocationServiceImpl implements SeatLocationService{

    @Autowired
    private SeatLocationDao seatLocationDao;

    @Override
    public int insert(SeatLocation seatLocation){
        return seatLocationDao.insert(seatLocation);
    }

    @Override
    public int insertSelective(SeatLocation seatLocation){
        return seatLocationDao.insertSelective(seatLocation);
    }

    @Override
    public int insertList(List<SeatLocation> seatLocations){
        return seatLocationDao.insertList(seatLocations);
    }

    @Override
    public int update(SeatLocation seatLocation){
        return seatLocationDao.update(seatLocation);
    }

    @Override
    public List<SeatLocation> getRoomSeats(String roomId) {
        return seatLocationDao.getRoomSeats(roomId);
    }

    @Override
    public int deleteSeat(String seatId) {
        return seatLocationDao.update(SeatLocation.builder()
                .seatId(seatId)
                .deleted(1)
                .build());
    }
}
