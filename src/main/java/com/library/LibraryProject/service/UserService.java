package com.library.LibraryProject.service;

import java.util.List;
import com.library.LibraryProject.entity.User;

public interface UserService{

    int insert(User user);

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
}
