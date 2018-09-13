package com.library.LibraryProject.service;

import java.util.List;
import com.library.LibraryProject.entity.User;
public interface UserService{

    int insert(User user);

    int insertSelective(User user);

    int insertList(List<User> users);

    int update(User user);
}
