package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.common.ResultCode;
import com.library.libraryproject.entity.Param.OrderSeatParam;
import com.library.libraryproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dcl
 * @date 2018年10月7日16:07:37
 * */

@Controller
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private OrderService orderService;
    /**
     * 占座方法
     * 考虑占座和预约共用同一个Controller
     * */
    @RequestMapping("/order")
    @ResponseBody
    public AjaxResult orderSeat(OrderSeatParam param){
        // 在此处进行参数校验和用户状态校验

        Boolean orderResult;
        try {
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
}
