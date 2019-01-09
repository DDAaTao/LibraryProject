package com.library.libraryproject.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.library.libraryproject.entity.Manager;
import com.library.libraryproject.dao.ManagerDao;
import com.library.libraryproject.service.ManagerService;
import org.springframework.transaction.annotation.Transactional;

@Service
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

    @Override
    public int dropByAccount(String managerAccount) {
        return managerDao.deleteByManagerAccount(managerAccount);
    }

    @Override
    public int registerManager(Manager manager) {
        if (StringUtils.isBlank(manager.getManagerAccount())
                || StringUtils.isBlank(manager.getManagerPwd())){
            throw new RuntimeException("传入的账号或密码为空");
        }
        return managerDao.insert(manager);
    }
}
