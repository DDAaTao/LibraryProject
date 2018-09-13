package com.library.LibraryProject.service;

import java.util.List;
import com.library.LibraryProject.entity.SeatStatus;
public interface SeatStatusService{

    int insert(SeatStatus seatStatus);

    int insertSelective(SeatStatus seatStatus);

    int insertList(List<SeatStatus> seatStatuss);

    int update(SeatStatus seatStatus);
}
