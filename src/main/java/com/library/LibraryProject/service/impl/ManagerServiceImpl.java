package com.library.LibraryProject.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.library.LibraryProject.entity.Manager;
import com.library.LibraryProject.dao.ManagerDao;
import com.library.LibraryProject.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Resource
    private ManagerDao managerDao;

    @Override
    public int insert(Manager manager){
        return managerDao.insert(manager);
    }

    @Override
    public int insertSelective(Manager manager){
        return managerDao.insertSelective(manager);
    }

    @Override
    public int insertList(List<Manager> managers){
        return managerDao.insertList(managers);
    }

    @Override
    public int update(Manager manager){
        return managerDao.update(manager);
    }
}
