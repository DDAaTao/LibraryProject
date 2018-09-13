package com.library.LibraryProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.LibraryProject.entity.SeatStatus;

@Mapper
public interface SeatStatusDao {
    int insert(@Param("seatStatus") SeatStatus seatStatus);

    int insertSelective(@Param("seatStatus") SeatStatus seatStatus);

    int insertList(@Param("seatStatuss") List<SeatStatus> seatStatuss);

    int update(@Param("seatStatus") SeatStatus seatStatus);
}
