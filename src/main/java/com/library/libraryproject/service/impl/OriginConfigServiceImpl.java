package com.library.libraryproject.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.library.libraryproject.entity.OriginConfig;
import com.library.libraryproject.dao.OriginConfigDao;
import com.library.libraryproject.service.OriginConfigService;

@Service
public class OriginConfigServiceImpl implements OriginConfigService{

    @Resource
    private OriginConfigDao originConfigDao;

    @Override
    public int insert(OriginConfig originConfig){
        return originConfigDao.insert(originConfig);
    }

    @Override
    public int insertSelective(OriginConfig originConfig){
        return originConfigDao.insertSelective(originConfig);
    }

    @Override
    public int insertList(List<OriginConfig> originConfigs){
        return originConfigDao.insertList(originConfigs);
    }

    @Override
    public int update(OriginConfig originConfig){
        return originConfigDao.update(originConfig);
    }
}
