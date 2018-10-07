package com.library.LibraryProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.library.LibraryProject.entity.SeatStatus;
import com.library.LibraryProject.dao.SeatStatusDao;
import com.library.LibraryProject.service.SeatStatusService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SeatStatusServiceImpl implements SeatStatusService{

    @Autowired
    private SeatStatusDao seatStatusDao;

    @Override
    public int insert(SeatStatus seatStatus){
        return seatStatusDao.insert(seatStatus);
    }

    @Override
    public int insertSelective(SeatStatus seatStatus){
        return seatStatusDao.insertSelective(seatStatus);
    }

    @Override
    public int insertList(List<SeatStatus> seatStatuss){
        return seatStatusDao.insertList(seatStatuss);
    }

    @Override
    public int update(SeatStatus seatStatus){
        return seatStatusDao.update(seatStatus);
    }
}
