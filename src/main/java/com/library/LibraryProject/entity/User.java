package com.library.LibraryProject.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author 文涛
 * @date 2018年9月14日00:01:30
 * */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget("user")
public class User {
    private Integer userId;
    @Excel(name = "用户姓名")
    private String userName;
    @Excel(name = "证件号")
    private String userNumber;
    @Excel(name = "初始密码")
    private String userPassword;
    @Excel(name = "性别")
    private String userSex;
    private String userAcademy;
    private String userProfession;
    private String userViolation;
    private String userStatus;
}
