package com.library.libraryproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.libraryproject.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDao {
    int insert(@Param("order") Order order);

    int insertSelective(@Param("order") Order order);

    int insertList(@Param("orders") List<Order> orders);

    int update(@Param("order") Order order);

    List<Order> findBySeatId(@Param("seatId")String seatId);

    List<Order> findByUserId(@Param("userId")Integer userId);


}
