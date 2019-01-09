package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.common.ResultCode;
import com.library.libraryproject.entity.Param.OrderSeatParam;
import com.library.libraryproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dcl
 * @date 2018年10月7日16:07:37
 * */

@Controller
@RequestMapping("/seat")
@CrossOrigin
public class SeatController {

    @Autowired
    private OrderService orderService;
    /**
     * 占座方法
     * 考虑占座和预约共用同一个Controller
     * */
    @PostMapping("/order")
    @ResponseBody
    public AjaxResult orderSeat(OrderSeatParam param){
        // 在此处进行参数校验和用户状态校验 todo 可优化：加一个统一的异常拦截过滤器，将对应的异常抛给前端
        try{
            checkOrderParam(param);
        }catch (Exception e){
            return AjaxResult.fail(ResultCode.PARAM_ERROR.getCode(), e.getMessage());
        }
        Boolean orderResult;
        try {
            // 调用占座方法
            orderResult = orderService.orderSeat(param);
        }catch (Exception e){
            return AjaxResult.fail(ResultCode.ORDER_FAIL.getCode(), ResultCode.ORDER_FAIL.getMsg());
        }
        if (orderResult){
            return AjaxResult.success();
        }else {
            return AjaxResult.fail(ResultCode.ORDER_FAIL.getCode(), ResultCode.ORDER_FAIL.getMsg());
        }
    }

    /**
     * 导入座位方法
     * */

    /**
     * 删除座位方法
     * */

    /**
     * 占座撤销方法
     * */

    /**
     * 预约占座方法
     * */

    /**
     * 获取某Room内所有座位信息以及当前占座状态信息
     * */

    /**
     * 获取某座位的今/明两天的占座信息
     * */
    @RequestMapping("/order/msg")
    @ResponseBody
    public AjaxResult getNearOrderMsg(){
        // todo


        return AjaxResult.success();
    }



    private void checkOrderParam(OrderSeatParam param){
        Assert.notNull(param.getUserId(), "预约用户Id为空");
        Assert.notNull(param.getSeatId(), "预约座位Id为空");
        Assert.notNull(param.getOrderStart(), "预约开始时间为空");
        Assert.notNull(param.getOrderFinish(), "预约结束时间为空");
    }
}
