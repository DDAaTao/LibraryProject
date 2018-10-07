package com.library.LibraryProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.library.LibraryProject.entity.Manager;
import com.library.LibraryProject.dao.ManagerDao;
import com.library.LibraryProject.service.ManagerService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
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

    @Override
    public List<Manager> searchAll(){
        return managerDao.find();
    }

    @Override
    public Manager searchByAccountAndPwd(String managerAccount, String managerPwd) {
        return managerDao.findByManagerAccountAndManagerPwd(managerAccount, managerPwd);
    }
}
