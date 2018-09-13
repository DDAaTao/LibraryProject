package com.library.LibraryProject.service;

import java.util.List;
import com.library.LibraryProject.entity.Order;
public interface OrderService{

    int insert(Order order);

    int insertSelective(Order order);

    int insertList(List<Order> orders);

    int update(Order order);
}
