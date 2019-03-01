package com.library.libraryproject.service;

import java.util.List;
import com.library.libraryproject.entity.Order;
import com.library.libraryproject.entity.Param.OrderSeatParam;
import com.library.libraryproject.entity.Param.RoomSeatsQueryParam;
import com.library.libraryproject.entity.vo.RoomSeatAndStatusVO;

public interface OrderService{

    int insert(Order order);

    /**
     * 占座方法
     * */
    Boolean orderSeat(OrderSeatParam param);

    /**
     * 获取某座位的今/明两天的占座信息,实际上其他天的信息已经被其他逻辑限制了
     * */
    List<Order> getNearOrderMsg(String seatId);

    /**
     * 获取某Room内所有座位信息以及当前占座状态信息,list里暂时只有seatId和seatStatus两个参数数据
     * */
    List<RoomSeatAndStatusVO> getRoomOrders(String roomId);

    /**
     * 用户手动结束占座
     * */
    void finishOrder(Integer userId);

}
