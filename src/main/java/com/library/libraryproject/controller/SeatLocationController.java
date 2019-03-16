package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.common.ResultCode;
import com.library.libraryproject.entity.Param.RoomSeatsQueryParam;
import com.library.libraryproject.entity.SeatLocation;
import com.library.libraryproject.entity.dto.Area;
import com.library.libraryproject.service.OriginConfigService;
import com.library.libraryproject.service.SeatLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author dcl
 * */
@Controller
@CrossOrigin
@RequestMapping("/location")
public class SeatLocationController {

    @Autowired
    private OriginConfigService originConfigService;

    @Autowired
    private SeatLocationService seatLocationService;

    /**
     * test
     * */
    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AjaxResult getParam(@RequestBody RoomSeatsQueryParam param){
        System.out.println(param);
        return AjaxResult.success(param);
    }

    /**
     * 获取所有阅览室信息
     * */
    @RequestMapping("/all")
    @ResponseBody
    public AjaxResult getAllLocation(){
        List<Area> allRegion = originConfigService.getAllRegion();
        return AjaxResult.success(allRegion);
    }
    /**
     * 获取某阅览室座位信息
     * */
    @RequestMapping("/room")
    @ResponseBody
    public AjaxResult getRoomSeats(String roomId){
        List<SeatLocation> roomSeats = seatLocationService.getRoomSeats(roomId);
        return AjaxResult.success(roomSeats);
    }

    /**
     * 导入座位信息表（manager）
     * */

    /**
     * 删除座位方法（manager）
     * */
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult deleteSeats(String seatId){
        int i = seatLocationService.deleteSeat(seatId);
        if (i >= 0){
            return AjaxResult.success();
        }else {
            return AjaxResult.fail(ResultCode.DELETE_SEAT_ERROR.getCode(), " 删除座位失败，请检查座位选择是否有误");
        }
    }

    /**
     * 恢复逻辑删除座位方法（manager）
     * */
    @RequestMapping("/recover")
    @ResponseBody
    public AjaxResult recoverSeats(String seatId){
        int i = seatLocationService.recoverSeat(seatId);
        if (i >= 0){
            return AjaxResult.success();
        }else {
            return AjaxResult.fail(ResultCode.RECOVER_SEAT_ERROR.getCode(), " 恢复座位失败，请检查座位选择是否有误");
        }
    }

    /**
     * 物理删除座位方法
     * */
    @RequestMapping("/realDelete")
    @ResponseBody
    public AjaxResult realDelete(String seatId){
        int i = seatLocationService.realDeleteSeat(seatId);
        if (i >= 0){
            return AjaxResult.success();
        }else {
            return AjaxResult.fail(ResultCode.DELETE_SEAT_ERROR.getCode(), " 恢复座位失败，请检查座位选择是否有误");
        }
    }

}
