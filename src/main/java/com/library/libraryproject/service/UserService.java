package com.library.libraryproject.service;

import java.util.List;
import com.library.libraryproject.entity.User;

public interface UserService{

    int insertSelective(User user);

    int insertList(List<User> users);

    int update(User user);

    /**
     * one user by id
     * */
    User queryByUserId(Integer userId);

    /**
     * select all user
     * */
    List<User> queryAll();

    int dropUserById(Integer userId);

    /**
     * 返回用户信息，顺便判断预约状态与当前时间，如果当前时间超过了六点，则返回的状态为可以预约，数据库状态不变
     * */
    User getUserForCheck(Integer userId);
}
