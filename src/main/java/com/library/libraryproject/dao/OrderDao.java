package com.library.libraryproject.dao;

import com.google.common.collect.Lists;
import com.library.libraryproject.entity.Param.DeleteOrderParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.libraryproject.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDao {
    int insert(@Param("order") Order order);

    int deleteOrder(@Param("param")DeleteOrderParam param);

    /**
     * 获取某座位的今/明两天的占座信息,实际上其他天的信息已经被其他逻辑限制了
     * */
    List<Order> findBySeatId(@Param("seatId")String seatId);

    List<Order> findByUserId(@Param("userId")Integer userId);

    /**
     * 获取座位list的今/明两天的占座信息,实际上其他天的信息已经被其他逻辑限制了
     * */
    List<Order> findBySeatIds(@Param("seatIds")List<String> seatIds);

    /**
     * 获取所有没有被逻辑删除的数据，用于后台进程进行脏数据清理
     * */
    List<Order> findByDeleted(Integer deleted);

    /**
     * 逻辑删除订单数据
     * */
    int deleteByOrderIds(@Param("orderIds") List<Integer> orderIds);

    /**
     * 获取用户的所有历史预约订单
     * */
    List<Order> getUserOrderHistory(@Param("userId") Integer userId);


}
