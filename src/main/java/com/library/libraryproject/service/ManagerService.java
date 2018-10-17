package com.library.libraryproject.service;

import java.util.List;
import com.library.libraryproject.entity.Manager;
public interface ManagerService{

    int insert(Manager manager);

    int insertSelective(Manager manager);

    int insertList(List<Manager> managers);

    int update(Manager manager);

    List<Manager> searchAll();

    Manager searchByAccountAndPwd(String managerAccount, String managerPwd);

    int dropByAccount(String managerAccount);

    int registerManager(Manager manager);
}
