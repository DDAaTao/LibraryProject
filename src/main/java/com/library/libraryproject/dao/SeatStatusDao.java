package com.library.libraryproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.libraryproject.entity.SeatStatus;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SeatStatusDao {
    int insert(@Param("seatStatus") SeatStatus seatStatus);

    int insertSelective(@Param("seatStatus") SeatStatus seatStatus);

    int insertList(@Param("seatStatus") List<SeatStatus> seatStatuss);

    int update(@Param("seatStatus") SeatStatus seatStatus);
}
