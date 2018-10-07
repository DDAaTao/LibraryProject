package com.library.LibraryProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.LibraryProject.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDao {
    int insert(@Param("order") Order order);

    int insertSelective(@Param("order") Order order);

    int insertList(@Param("orders") List<Order> orders);

    int update(@Param("order") Order order);
}
