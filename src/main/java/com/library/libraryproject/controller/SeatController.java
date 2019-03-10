package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.common.ResultCode;
import com.library.libraryproject.entity.Order;
import com.library.libraryproject.entity.Param.OrderSeatParam;
import com.library.libraryproject.entity.vo.RoomSeatAndStatusVO;
import com.library.libraryproject.service.OrderService;
import com.library.libraryproject.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author dcl
 * @date 2018年10月7日16:07:37
 * */

@Controller
@RequestMapping("/seat")
@CrossOrigin
@Slf4j
public class SeatController {

    @Autowired
    private OrderService orderService;
    /**
     * 占座方法
     * 考虑占座和预约共用同一个Controller
     * */
    @PostMapping("/order")
    @ResponseBody
    public AjaxResult orderSeat(@RequestBody OrderSeatParam param){
        // 在此处进行参数校验和用户状态校验
        try{
            checkOrderParam(param);
        }catch (Exception e){
            log.error(e.getMessage());
            return AjaxResult.fail(ResultCode.PARAM_ERROR.getCode(), e.getMessage());
        }

        // 检验占座时间是否满足要求
        if (!checkOrderTime(param)){
            return AjaxResult.fail(ResultCode.ORDER_TIME_ERROR.getCode(), ResultCode.ORDER_TIME_ERROR.getMsg());
        }
        // 校验用户状态与用户状态
        if (!orderService.userAndSeatStatusCheck(param)){
            return AjaxResult.fail(ResultCode.ORDER_FAIL.getCode(), "请检查用户状态是否有误或预约时间是否冲突");
        }

        Boolean orderResult;
        try {
            // 调用占座方法
            orderResult = orderService.orderSeat(param);
        }catch (Exception e){
            log.error(e.getMessage());
            return AjaxResult.fail(ResultCode.ORDER_FAIL.getCode(), ResultCode.ORDER_FAIL.getMsg());
        }
        if (orderResult){
            return AjaxResult.success();
        }else {
            return AjaxResult.fail(ResultCode.ORDER_FAIL.getCode(), ResultCode.ORDER_FAIL.getMsg());
        }
    }

    /**
     * 手动占座结束方法（同撤销）
     * */
    @RequestMapping("/order/finish")
    @ResponseBody
    public AjaxResult finishOrder(Integer userId){
        try {
            orderService.finishOrder(userId);
        } catch (Exception e){
            log.error(e.getMessage());
            return AjaxResult.fail(ResultCode.FINISH_ORDER_FAIL.getCode(), ResultCode.FINISH_ORDER_FAIL.getMsg());
        }
        return AjaxResult.success();
    }

    /**
     * 获取某Room内所有座位信息以及当前占座状态信息
     * */
    @RequestMapping("/room/orders")
    @ResponseBody
    public AjaxResult getRoomOrders(String roomId){
        List<RoomSeatAndStatusVO> roomOrders = orderService.getRoomOrders(roomId);
        return AjaxResult.success(roomOrders);
    }

    /**
     * 获取某座位的今/明两天的占座信息,实际上其他天的信息已经被其他逻辑限制了
     * */
    @RequestMapping("/order/msg")
    @ResponseBody
    public AjaxResult getNearOrderMsg(String seatId){
        List<Order> nearOrderMsg = orderService.getNearOrderMsg(seatId);
        return AjaxResult.success(nearOrderMsg);
    }

    /**
     * 进行参数的校验，并且进行时间的判断（用于占座上时间的限制）
     * */
    private void checkOrderParam(OrderSeatParam param){
        Assert.notNull(param.getUserId(), "预约用户Id为空");
        Assert.notNull(param.getSeatId(), "预约座位Id为空");
        Assert.notNull(param.getOrderStart(), "预约开始时间为空");
        Assert.notNull(param.getOrderFinish(), "预约结束时间为空");
    }

    /**
     * 进行时间的判断是否满足要求（用于占座上时间的限制）
     * 主要逻辑是判断当前时间是否大于18点，如果大于大于18点的话，则允许第二天的占座，并且只允许提前一天
     * 判断时间有两个维度，一个是创建时间、一个是预约开始和结束时间
     * 如果返回false代表不满足要求，如果返回true代表满足要求
     * */
    private Boolean checkOrderTime(OrderSeatParam param){
        // 预约起始时间要大于今天的起始,否则直接返回false
        /*if (DateUtils.getDayStartTime(DateUtils.now()).getTime() >= param.getOrderStart().getTime()){
            return false;
        }*/
        // 修改为大于等于当前时间
        if (DateUtils.now().getTime() > param.getOrderStart().getTime()){
            return false;
        }
        // 预约时间要大于半小时
        if (!(param.getOrderFinish().getTime() - param.getOrderStart().getTime() >= 1800000L)){
            return false;
        }
        // 先获取当天晚上六点的时间
        Date beginTime = DateUtils.getFormatDate("18:00:00", "HH:mm:ss");
        // 判断当前时间是否大于六点
        if (DateUtils.sameDayCompare(DateUtils.now(), beginTime)){
            // 如果当前时间已经大于六点，则允许预定，只要保证预约结束时间在第二天结束之前即可
            Date tomorrow = DateUtils.addDays(DateUtils.now(), 1);
            if (DateUtils.getDayEndTime(tomorrow).getTime() >= param.getOrderFinish().getTime()){
                return true;
            }
        } else {
            //如果当前时间小于六点，那么只能预约今天的，要保证预约结束时间在今天结束之前
            if (DateUtils.getDayEndTime(DateUtils.now()).getTime() >= param.getOrderFinish().getTime()){
                return true;
            }
        }
        return false;
    }
}
