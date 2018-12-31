package com.library.libraryproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.libraryproject.entity.SeatLocation;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SeatLocationDao {
    int insert(@Param("seatLocation") SeatLocation seatLocation);

    int insertSelective(@Param("seatLocation") SeatLocation seatLocation);

    int insertList(@Param("seatLocations") List<SeatLocation> seatLocations);

    int update(@Param("seatLocation") SeatLocation seatLocation);

    List<SeatLocation> getRoomSeats(@Param("seatArea")String seatArea, @Param("seatBuilding")String seatBuilding
            , @Param("seatStorey")String seatStorey, @Param("seatRoom")String seatRoom);

}
