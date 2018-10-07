package com.library.LibraryProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.library.LibraryProject.entity.SeatLocation;
import com.library.LibraryProject.dao.SeatLocationDao;
import com.library.LibraryProject.service.SeatLocationService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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
}
