package com.library.libraryproject.controller;

import com.library.libraryproject.common.AjaxResult;
import com.library.libraryproject.common.ResultCode;
import com.library.libraryproject.manager.UserManager;
import com.library.libraryproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 文涛
 * @date 2018年10月7日16:07:37
 * */

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;

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

    @RequestMapping("/importExcel")
    @ResponseBody
    public AjaxResult importExcel(MultipartFile userExcel){
        try {
            userManager.importUsers(userExcel);
        }catch (Exception e){
            log.error("上传失败", e);
            return AjaxResult.fail(ResultCode.UPLOAD_FAIL.getCode(), "上传所有用户失败");
        }
        return AjaxResult.success();
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public AjaxResult deleteUser(Integer userId){
        try {
            if (userService.dropUserById(userId) < 0){
                return AjaxResult.fail(ResultCode.DROP_FAIL.getCode(), "删除用户失败");
            }
        }catch (Exception e){
            return AjaxResult.fail(ResultCode.DROP_FAIL.getCode(), "删除用户失败");
        }
        return AjaxResult.success();
    }
}
