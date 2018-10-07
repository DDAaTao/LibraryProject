package com.library.LibraryProject.controller;

import com.library.LibraryProject.entity.Manager;
import com.library.LibraryProject.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 文涛
 * @date 2018年10月7日16:07:37
 * */

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    @ResponseBody
    public void managerLogin(Manager loginManager){
        try {
            Manager manager = managerService.searchByAccountAndPwd(
                    loginManager.getManagerAccount(), loginManager.getManagerPwd());
        }catch (Exception e){
            System.out.println("Manager登录失败");
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public void managerRegister(Manager registerManager){
        try {
            int insertFlag = managerService.insert(registerManager);
        }catch (Exception e){
            System.out.println("Manager注册失败");
        }
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Manager> allManager(){
        return managerService.searchAll();
    }
}
