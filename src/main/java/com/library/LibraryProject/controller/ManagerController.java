package com.library.LibraryProject.controller;

import com.library.LibraryProject.common.AjaxResult;
import com.library.LibraryProject.common.ResultCode;
import com.library.LibraryProject.entity.Manager;
import com.library.LibraryProject.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

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

    /**
     * Manager登录方法
     * */
    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult managerLogin(Manager loginManager){
        try {
            // todo 此处返回是否有必要？ 设计完登录信息存储方式再做考虑
            Manager manager = managerService.searchByAccountAndPwd(
                    loginManager.getManagerAccount(), loginManager.getManagerPwd());
            return AjaxResult.success(manager);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.fail(ResultCode.FAIL.getCode(),"Manager登录失败");
        }
    }

    /**
     * Manager注册方法
     *
     * 后端的参数校验做在service方法内部  todo 考虑定义一个统一的自用异常类
     * */
    @RequestMapping("/register")
    @ResponseBody
    public AjaxResult managerRegister(Manager registerManager){
        try {
            int insertFlag = managerService.registerManager(registerManager);
            if (insertFlag < 1){
                return AjaxResult.fail(ResultCode.FAIL.getCode(),"Manager注册出现问题,SQL插入失败");
            }
            return AjaxResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.fail(ResultCode.FAIL.getCode(),"Manager注册失败");
        }
    }

    /**
     * 查询所有管理员信息
     * */
    @RequestMapping("/all")
    @ResponseBody
    public AjaxResult allManager(){
        try {
            return AjaxResult.success(managerService.searchAll());
        }catch (Exception e){
            e.printStackTrace();
            // 为了防止恶意调用接口测试接口返回信息，特将返回于前端的错误提示进行模糊化修改
            return AjaxResult.fail(ResultCode.FAIL.getCode(),"获取失败");
        }
    }

    /**
     * 删除管理员
     * todo 此处需要做权限验证，尽快做好权限模型设计！（在此处也可以根据操作人的管理员级别进行权限管理）
     * */
    @RequestMapping("/drop")
    @ResponseBody
    public AjaxResult deleteManager(String managerAccount){
        try {
            int deleteFlag = managerService.dropByAccount(managerAccount);
            if (deleteFlag < 1){
                return AjaxResult.fail(ResultCode.DROP_MANAGER_FAIL.getCode(),"数据库中无此管理员信息");
            }
            return AjaxResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.fail(ResultCode.DROP_MANAGER_FAIL.getCode(),ResultCode.DROP_MANAGER_FAIL.getMsg());
        }
    }
}
