package com.library.LibraryProject.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.LibraryProject.entity.User;
import org.mybatis.spring.annotation.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    int insert(@Param("user") User user);

    int insertSelective(@Param("user") User user);

    int insertList(@Param("users") List<User> users);

    int update(@Param("user") User user);

    List<User> findByUserId(@Param("userId")Integer userId);

}
