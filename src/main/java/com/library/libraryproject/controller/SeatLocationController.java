package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.entity.dto.Area;
import com.library.libraryproject.service.OriginConfigService;
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
    /**
     * 获取所有阅览室信息信息 todo 此处需要设计一个List的返回
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


    /**
     *
     * */
}
