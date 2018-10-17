package com.library.libraryproject.service;

import java.util.List;
import com.library.libraryproject.entity.SeatStatus;
public interface SeatStatusService{

    int insert(SeatStatus seatStatus);

    int insertSelective(SeatStatus seatStatus);

    int insertList(List<SeatStatus> seatStatuss);

    int update(SeatStatus seatStatus);
}
