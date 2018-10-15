package com.library.LibraryProject.controller;

import com.library.LibraryProject.common.AjaxResult;
import com.library.LibraryProject.common.ResultCode;
import com.library.LibraryProject.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
