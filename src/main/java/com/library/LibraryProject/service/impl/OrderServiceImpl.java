package com.library.LibraryProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.library.LibraryProject.entity.Order;
import com.library.LibraryProject.dao.OrderDao;
import com.library.LibraryProject.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public int insert(Order order){
        return orderDao.insert(order);
    }

    @Override
    public int insertSelective(Order order){
        return orderDao.insertSelective(order);
    }

    @Override
    public int insertList(List<Order> orders){
        return orderDao.insertList(orders);
    }

    @Override
    public int update(Order order){
        return orderDao.update(order);
    }
}
