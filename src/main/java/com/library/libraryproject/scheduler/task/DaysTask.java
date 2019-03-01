package com.library.libraryproject.scheduler.task;

import com.library.libraryproject.dao.OrderDao;
import com.library.libraryproject.dao.UserDao;
import com.library.libraryproject.entity.Order;
import com.library.libraryproject.entity.Param.RecoverUserStatusParam;
import com.library.libraryproject.entity.enums.UserStatus;
import com.library.libraryproject.service.UserService;
import com.library.libraryproject.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dcl
 * */
@Component
@Slf4j
public class DaysTask {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void orderTask(){
        Date now = DateUtils.now();
        log.info("orderTask start:" + now);
        // 获取所有没有被逻辑删除的订单信息
        List<Order> byDeleted = orderDao.findByDeleted(0);
        // 如果没有数据则直接结束
        if (CollectionUtils.isEmpty(byDeleted)){
            log.info("none order ! orderTask end:" + DateUtils.now());
            return;
        }
        // 创建一个需要被逻辑删除的订单idList
        List<Integer> needDeleteIds = new ArrayList<>(byDeleted.size());
        // 创建一个需要恢复状态的idList
        List<Integer> needRecoverUserIds = new ArrayList<>(byDeleted.size());
        // 便利所有相关的订单信息，判断其是否是需要进行逻辑删除的订单
        for (Order order : byDeleted) {
            // 判断的条件是，订单结束时间在当前时间之前
            if (order.getOrderFinish().getTime() < now.getTime()){
                needDeleteIds.add(order.getOrderId());
                needRecoverUserIds.add(order.getUserId());
            }
        }
        // 执行逻辑删除订单信息的sql
        orderDao.deleteByOrderIds(needDeleteIds);
        log.info("完成逻辑删除订单信息:" + DateUtils.now());
        // 执行恢复相关用户状态的sql
        userService.recoverUserStatus(RecoverUserStatusParam.builder()
                .status(UserStatus.FREE.getCode())
                .userIds(needRecoverUserIds)
                .build());
        log.info("完成恢复相关用户状态:" + DateUtils.now());
        log.info("orderTask end:" + DateUtils.now());
    }
}
