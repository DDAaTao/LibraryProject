package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.common.ResultCode;
import com.library.libraryproject.dao.OrderDao;
import com.library.libraryproject.dao.UserDao;
import com.library.libraryproject.entity.Order;
import com.library.libraryproject.entity.User;
import com.library.libraryproject.manager.UserManager;
import com.library.libraryproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.library.libraryproject.common.ResultCode.PARAM_ERROR;
import static com.library.libraryproject.common.ResultCode.USER_LOGIN_ERROR;

/**
 * @author dcl
 * @date 2018年10月7日16:07:37
 * */

@Slf4j
@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    /**
     * 获取所有的用户
     * */
    @RequestMapping("/all")
    @ResponseBody
    public AjaxResult allUser(){
        return AjaxResult.success(userDao.find());
    }

    /**
     * 下载所有用户Excel
     * */
    @RequestMapping("/allUserDownload")
    @ResponseBody
    public AjaxResult allUserDownload(HttpServletResponse httpServletResponse){
        try {
            userManager.allUsersDownload(httpServletResponse);
        } catch (IOException e) {
            log.error("下载失败", e);
            return AjaxResult.fail(ResultCode.DOWNLOAD_FAIL.getCode(), "下载所有用户表失败");
        }
        return AjaxResult.success();
    }

    /**
     * 导入文件
     * */
    @PostMapping("/importExcel")
    @ResponseBody
    public AjaxResult importExcel(@RequestBody MultipartFile userExcel){
        try {
            userManager.importUsers(userExcel);
        }catch (Exception e){
            log.error("上传失败", e);
            return AjaxResult.fail(ResultCode.UPLOAD_FAIL.getCode(), "上传所有用户失败");
        }
        return AjaxResult.success();
    }

    /**
     * 新增单个用户方法
     * */
    @PostMapping("/addUser")
    @ResponseBody
    public AjaxResult addUser(@RequestBody User user){
        try {
            userService.insertSelective(user);
        } catch (Exception e){
            log.error(e.getMessage());
            return AjaxResult.fail(ResultCode.ADD_USER_ERROR.getCode(), ResultCode.ADD_USER_ERROR.getMsg());
        }
        return AjaxResult.success();
    }

    /**
     * 删除用户
     * */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public AjaxResult deleteUser(Integer userId){
        try {
            if (userService.dropUserById(userId) < 0){
                return AjaxResult.fail(ResultCode.DROP_FAIL.getCode(), "删除用户失败");
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return AjaxResult.fail(ResultCode.DROP_FAIL.getCode(), "删除用户失败");
        }
        return AjaxResult.success();
    }

    /**
     * 获取用户信息，多处通用
     * 前端可以利用获取的用户信息进行状态的判断，从而判断其是否能够占座
     * */
    @RequestMapping("/user")
    @ResponseBody
    public AjaxResult getUserMsg(Integer userId){
        if (userId == null){
            return AjaxResult.fail(PARAM_ERROR.getCode(), "用户信息为null");
        }
        return AjaxResult.success(userService.getUserForCheck(userId));
    }

    /**
     * 用户登陆接口
     * */
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult userLogin(@RequestBody User user){
        // 参数校验
        if (StringUtils.isBlank(user.getUserNumber()) || StringUtils.isBlank(user.getUserPassword())){
            return AjaxResult.fail(PARAM_ERROR.getCode(), "请输入用户账号或密码");
        }
        User userLogin = userService.userLogin(user);
        if (userLogin == null){
            return AjaxResult.fail(USER_LOGIN_ERROR.getCode(), "用户登陆失败，请检查用户名和密码是否有误");
        }
        return AjaxResult.success(userLogin);
    }

    /**
     * 查询用户的当前占座信息，用于展示（手动结束占座）
     * */
    @RequestMapping("/order/msg")
    @ResponseBody
    public AjaxResult getUserOrderMessage(Integer userId){
        List<Order> byUserId = orderDao.findByUserId(userId);
        return AjaxResult.success(byUserId);
    }

    /**
     * 查询用户所有占座记录
     * */
    @RequestMapping("/order/history")
    @ResponseBody
    public AjaxResult getUserOrderHistory(Integer userId){
        List<Order> byUserId = orderDao.getUserOrderHistory(userId);
        return AjaxResult.success(byUserId);
    }
}
