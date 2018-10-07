package com.library.LibraryProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.LibraryProject.entity.SeatLocation;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SeatLocationDao {
    int insert(@Param("seatLocation") SeatLocation seatLocation);

    int insertSelective(@Param("seatLocation") SeatLocation seatLocation);

    int insertList(@Param("seatLocations") List<SeatLocation> seatLocations);

    int update(@Param("seatLocation") SeatLocation seatLocation);
}
