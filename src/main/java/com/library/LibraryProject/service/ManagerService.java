package com.library.LibraryProject.service;

import java.util.List;
import com.library.LibraryProject.entity.Manager;
public interface ManagerService{

    int insert(Manager manager);

    int insertSelective(Manager manager);

    int insertList(List<Manager> managers);

    int update(Manager manager);
}
