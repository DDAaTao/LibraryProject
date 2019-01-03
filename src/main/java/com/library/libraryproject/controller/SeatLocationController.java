package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.entity.Param.RoomSeatsQueryParam;
import com.library.libraryproject.entity.SeatLocation;
import com.library.libraryproject.entity.dto.Area;
import com.library.libraryproject.service.OriginConfigService;
import com.library.libraryproject.service.SeatLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * @author dcl
 * */
@Controller
@RequestMapping("/location")
public class SeatLocationController {

    @Autowired
    private OriginConfigService originConfigService;

    @Autowired
    private SeatLocationService seatLocationService;

    /**
     * 获取所有阅览室信息信息
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
    public AjaxResult getRoomSeats(RoomSeatsQueryParam param){
        List<SeatLocation> roomSeats = seatLocationService.getRoomSeats(param);
        return AjaxResult.success(roomSeats);
    }

    /**
     * 导入座位信息表
     * */


}
