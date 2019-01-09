package com.library.libraryproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.library.libraryproject.entity.User;
import com.library.libraryproject.dao.UserDao;
import com.library.libraryproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    /**
     * 在调用此方法的时候要注意相关默认字段的处理
     * */
    @Override
    public int insert(User user){
        return userDao.insert(user);
    }

    @Override
    public int insertSelective(User user){
        return userDao.insertSelective(user);
    }

    @Override
    public int insertList(List<User> users){
        return userDao.insertList(users);
    }

    @Override
    public int update(User user){
        return userDao.update(user);
    }

    @Override
    public User queryByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public List<User> queryAll() {
        return userDao.find();
    }

    @Override
    public int dropUserById(Integer userId) {
        return userDao.deleteByUserId(userId);
    }
}
