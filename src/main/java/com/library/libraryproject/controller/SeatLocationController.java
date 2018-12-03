package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.entity.dto.Area;
import com.library.libraryproject.service.OriginConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("location")
public class SeatLocationController {

    @Autowired
    private OriginConfigService originConfigService;
    /**
     * 获取所有阅览室信息信息 todo 此处需要设计一个List的返回
     * */
    @RequestMapping("/location/all")
    public List<Area> getAllLocation(){
        List<Area> allRegion = originConfigService.getAllRegion();
        return allRegion;
    }
    /**
     * 获取某阅览室座位信息
     * */


    /**
     *
     * */
}
