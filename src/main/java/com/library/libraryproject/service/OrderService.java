package com.library.libraryproject.service;

import java.util.List;
import com.library.libraryproject.entity.Order;
public interface OrderService{

    int insert(Order order);

    int insertSelective(Order order);

    int insertList(List<Order> orders);

    int update(Order order);
}
