package com.library.libraryproject.manager.impl;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.library.libraryproject.entity.User;
import com.library.libraryproject.manager.UserManager;
import com.library.libraryproject.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    /**
     * todo 此处需要维护一个自己的异常
     * */
    @Override
    public void importUsers(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        InputStream in = multipartFile.getInputStream();
        // 得到Excel
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if ((".xls").equals(fileType)){
            workbook = new HSSFWorkbook(in);
        }else if ((".xlsx").equals(fileType)){
            workbook = new XSSFWorkbook(in);
        }else {
            throw new RuntimeException("传入文件格式错误");
        }
        // 得到sheet 默认取第一个sheet 获取
        Sheet sheet = workbook.getSheetAt(0);
        // 获取实际行数
        int rowsNum = sheet.getLastRowNum();
        List<User> userList = new ArrayList<>(rowsNum);
        // 读取
        for (int i = 1; i < rowsNum + 1; i++ ){
            Row row = sheet.getRow(i);
            if (row != null){
                userList.add(User.builder()
                        .userNumber(row.getCell(0).toString())
                        .userName(row.getCell(1).toString())
                        .userPassword(row.getCell(2).toString())
                        .userSex(row.getCell(3).toString())
                        .userAcademy(row.getCell(4).toString())
                        .build());
            }
        }
        if (!userList.isEmpty()){
            userService.insertList(userList);
        }
        workbook.close();
    }
}
