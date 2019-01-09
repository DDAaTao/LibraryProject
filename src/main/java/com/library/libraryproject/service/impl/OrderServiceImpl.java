package com.library.libraryproject.service.impl;

import com.library.libraryproject.dao.UserDao;
import com.library.libraryproject.entity.Param.OrderSeatParam;
import com.library.libraryproject.entity.User;
import com.library.libraryproject.entity.enums.OrderStatus;
import com.library.libraryproject.entity.enums.UserStatus;
import com.library.libraryproject.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.library.libraryproject.entity.Order;
import com.library.libraryproject.dao.OrderDao;
import com.library.libraryproject.service.OrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author dcl
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Override
    public int insert(Order order){
        order.setDeleted(0);
        return orderDao.insert(order);
    }

    @Override
    public int insertSelective(Order order){
        return orderDao.insertSelective(order);
    }

    @Override
    public int insertList(List<Order> orders){
        return orderDao.insertList(orders);
    }

    @Override
    public int update(Order order){
        return orderDao.update(order);
    }

    /**
     * 需要注意是否已经被占座/占座的时间内是否有冲突，其次要考虑并发场景（CAS算法）
     * 前端也要做时间段的校验，双重控制
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean orderSeat(OrderSeatParam param) {
        // 初步先在后端进行一次校验，后续再进行扩展
        List<Order> orderList = orderDao.findByseatId(param.getSeatId());
        // 当数据库中有该座位的占座信息时，判断此处占座时间是否有冲突
        if (!CollectionUtils.isEmpty(orderList)){
            // 遍历所有占座信息
            for (Order order : orderList) {
                // 进行时间冲突的判断，冲突的情况分为两种，一种为起始时间在原区间中间
                if (param.getOrderStart().getTime() > order.getOrderStart().getTime()
                        && param.getOrderStart().getTime() < order.getOrderFinish().getTime()){
                    return false;
                }
                // 另外一种是结束时间在原区间中间
                if (param.getOrderFinish().getTime() > order.getOrderStart().getTime()
                        && param.getOrderFinish().getTime() < order.getOrderFinish().getTime()){
                    return false;
                }
            }
        }
        // 如果上述异常情况无发生，则进行占座信息的插入
        int insert = orderDao.insert(Order.builder()
                .orderCreate(DateUtils.now())
                .orderStart(param.getOrderStart())
                // 注意此处为了防止时间冲突，结束时间默认减去1S
                .orderFinish(new Date(param.getOrderFinish().getTime() - 1000))
                .orderStatus(OrderStatus.NORMAL.getCode())
                .deleted(0)
                .build());
        // 占座信息插入后，更新占座用户信息为已占座
        userDao.update(User.builder()
                .userId(param.getUserId())
                .userStatus(UserStatus.BOOKED.getCode())
                .build());
        return insert > 0 ;
    }
}
