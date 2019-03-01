package com.library.libraryproject.service.impl;

import com.library.libraryproject.dao.OrderDao;
import com.library.libraryproject.entity.Order;
import com.library.libraryproject.entity.Param.RecoverUserStatusParam;
import com.library.libraryproject.entity.enums.UserStatus;
import com.library.libraryproject.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.library.libraryproject.entity.User;
import com.library.libraryproject.dao.UserDao;
import com.library.libraryproject.service.UserService;
import org.springframework.util.CollectionUtils;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public int insertSelective(User user){
        user.setUserViolation("0");
        user.setUserStatus(UserStatus.FREE.getCode());
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
    public int recoverUserStatus(RecoverUserStatusParam param) {
        return userDao.updateUsersStatus(param);
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

    @Override
    public User getUserForCheck(Integer userId) {
        // 获取用户信息
        User user = userDao.findByUserId(userId);
        // 判断用户状态，如果是自由状态可以直接返回
        if (UserStatus.FREE.getCode().equalsIgnoreCase(user.getUserStatus())){
            return user;
        }
        // 如果不是自由状态，判断其预约信息
        List<Order> byUserId = orderDao.findByUserId(userId);
        if (CollectionUtils.isEmpty(byUserId)){
            // 如果返回的预约信息是空，则代表暂时没有预约信息，所以可以将用户状态更换为free状态
            user.setUserStatus(UserStatus.FREE.getCode());
            // 将用户信息更新到数据库中
            userDao.update(user);
        } else {
            // 如果返回的预约信息不为空，则遍历其预约信息，判断当前是否可以进行判断
            for (Order order : byUserId) {
                // 如果预约的起始时间大于当前时间，则代表其是有预约信息的
                if (order.getOrderStart().getTime() > DateUtils.now().getTime()){
                    // 如果有预约信息的此时直接返回预约数据即可
                    return user;
                }
            }
            // 如果遍历完后发现没有真实有效的预约信息，则更换用户状态并且更新到数据库中
            user.setUserStatus(UserStatus.FREE.getCode());
            // 将用户信息更新到数据库中
            userDao.update(user);
        }
        // 最后返回用户信息
        return user;
    }

    @Override
    public User userLogin(User user) {
        User userByNumberAndPassword = userDao.findUserByNumberAndPassword(user);
        return userByNumberAndPassword;
    }
}
