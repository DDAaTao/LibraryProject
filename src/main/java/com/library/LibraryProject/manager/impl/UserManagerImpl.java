package com.library.LibraryProject.manager.impl;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.library.LibraryProject.entity.User;
import com.library.LibraryProject.manager.UserManager;
import com.library.LibraryProject.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 文涛
 * 2018年10月15日23:39:13
 * */

@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserService userService;

    @Override
    public void allUsersDownload(HttpServletResponse httpServletResponse) throws IOException {
        List<User> allUser = userService.queryAll();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("系统所有用户表","User")
                ,User.class ,allUser);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }
}
