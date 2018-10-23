package com.library.libraryproject.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.library.libraryproject.entity.dto.Area;
import com.library.libraryproject.entity.dto.Buliding;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public List<Area> getAllRegion() {
        List<OriginConfig> originConfigs = originConfigDao.find();
        List<Area> areas = new ArrayList<>();
        // 此处采用的是JDK1.8版本的lambda表达式代替for循环，使得格式上更加优美，便于阅读
        originConfigs.forEach(originConfig ->
            areas.add(Area.builder()
                    .name(originConfig.getConfigName())
                    .bulidings((List<Buliding>) JSONArray.parse(originConfig.getConfigBody()))
                    .build())
        );
        return areas;
    }
}
