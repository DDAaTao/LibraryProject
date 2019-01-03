package com.library.libraryproject.service;

import java.util.List;
import com.library.libraryproject.entity.Order;
import com.library.libraryproject.entity.Param.OrderSeatParam;

public interface OrderService{

    int insert(Order order);

    int insertSelective(Order order);

    int insertList(List<Order> orders);

    int update(Order order);

    /**
     * 占座方法
     * */
    Boolean orderSeat(OrderSeatParam param);
}
