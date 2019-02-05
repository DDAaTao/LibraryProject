package com.library.libraryproject.service.impl;

import com.google.common.collect.Lists;
import com.library.libraryproject.dao.UserDao;
import com.library.libraryproject.entity.Param.DeleteOrderParam;
import com.library.libraryproject.entity.Param.OrderSeatParam;
import com.library.libraryproject.entity.Param.RoomSeatsQueryParam;
import com.library.libraryproject.entity.SeatLocation;
import com.library.libraryproject.entity.User;
import com.library.libraryproject.entity.enums.OrderStatus;
import com.library.libraryproject.entity.enums.SeatStatusType;
import com.library.libraryproject.entity.enums.UserStatus;
import com.library.libraryproject.entity.vo.RoomSeatAndStatusVO;
import com.library.libraryproject.service.SeatLocationService;
import com.library.libraryproject.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private SeatLocationService seatLocationService;

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

    /**
     * 需要注意是否已经被占座/占座的时间内是否有冲突，其次要考虑并发场景（CAS算法）
     * 前端也要做时间段的校验，双重控制
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean orderSeat(OrderSeatParam param) {
        // 初步先在后端进行一次校验，后续再进行扩展
        List<Order> orderList = orderDao.findBySeatId(param.getSeatId());
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

    @Override
    public List<Order> getNearOrderMsg(String seatId) {
        return  orderDao.findBySeatId(seatId);
    }

    @Override
    public List<RoomSeatAndStatusVO> getRoomOrders(String roomId) {
        // 先根据room信息获取其内的所有座位id
        List<SeatLocation> roomSeats = seatLocationService.getRoomSeats(roomId);
        // 将座位信息list转化为id的list
        List<String> seatIds = roomSeats.stream().map(SeatLocation::getSeatId).collect(Collectors.toList());
        // 通过id去查询order表里的所有相关占座信息
        List<Order> bySeatIds = orderDao.findBySeatIds(seatIds);
        // 先将相关的占座信息封装成id为key信息为value的形式，以便于后续的逻辑
        Map<String, List<Order>> orderBySeatId = new HashMap<>(bySeatIds.size());
        // 进行封装
        for (Order bySeatId : bySeatIds) {
            // 如果map里已有对应的id，则添加进去
            if (orderBySeatId.containsKey(bySeatId.getSeatId())){
                orderBySeatId.get(bySeatId.getSeatId()).add(bySeatId);
            } else {
                // 如果没有对应的id，则新增一个list添加进去
                orderBySeatId.put(bySeatId.getSeatId(), Lists.newArrayList(bySeatId));
            }
        }
        // 将占座信息封装成前端需要的样式
        List<RoomSeatAndStatusVO> resultList = new ArrayList<>(roomSeats.size());
        for (SeatLocation roomSeat : roomSeats) {
            // 如果座位状态是deleted 的，则代表座位弃用，进行插入后即刻进行下一次循环
            if (roomSeat.getDeleted() == 1){
                resultList.add(RoomSeatAndStatusVO.builder()
                        .seatId(roomSeat.getSeatId())
                        .seatStatus(SeatStatusType.DEPRECATED.getCode())
                        .build());
                continue;
            }
            // 如果能获取到信息代表此座位正在使用，如果获取的为空代表座位可以使用
            List<Order> orders = orderBySeatId.get(roomSeat.getSeatId());
            if (CollectionUtils.isEmpty(orders)){
                resultList.add(RoomSeatAndStatusVO.builder()
                        .seatId(roomSeat.getSeatId())
                        .seatStatus(SeatStatusType.FREE.getCode())
                        .build());
            } else {
                resultList.add(RoomSeatAndStatusVO.builder()
                        .seatId(roomSeat.getSeatId())
                        .seatStatus(SeatStatusType.BOOKED.getCode())
                        .build());
            }
        }
        return resultList;
    }

    @Override
    @Transactional
    public void finishOrder(Integer userId) {
        // 占座信息：先查order，判断有无，如果无直接返回，如果有则进行update
        List<Order> byUserId = orderDao.findByUserId(userId);
        if (CollectionUtils.isEmpty(byUserId)){
            return;
        }
        // 如果有占座信息则逻辑删除占座信息
        List<Integer> orderIds = byUserId.stream().map(Order::getOrderId).collect(Collectors.toList());
        orderDao.deleteOrder(DeleteOrderParam.builder()
                .deleted(1)
                .mdfDate(DateUtils.now())
                .orderIds(orderIds)
                .build());
        // 查询个人信息
        User user = userDao.findByUserId(userId);
        // 判断状态是否是自由状态，如果不是则更新为自由状态
        if (UserStatus.FREE.getCode().equalsIgnoreCase(user.getUserStatus())){
            return;
        }
        // 如果不是则更新用户信息
        userDao.update(User.builder()
                .userId(user.getUserId())
                .userStatus(UserStatus.FREE.getCode())
                .build());
    }
}
