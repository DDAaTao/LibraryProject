package com.library.LibraryProject.service;

import java.util.List;
import com.library.LibraryProject.entity.SeatLocation;
public interface SeatLocationService{

    int insert(SeatLocation seatLocation);

    int insertSelective(SeatLocation seatLocation);

    int insertList(List<SeatLocation> seatLocations);

    int update(SeatLocation seatLocation);
}
