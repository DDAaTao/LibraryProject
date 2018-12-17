package com.library.libraryproject.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.library.libraryproject.entity.dto.Area;
import com.library.libraryproject.entity.dto.Building;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

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

    /**
     * todo 此处需要做缓存处理，可暂定5分钟缓存一次
     * */
    @Override
    public List<Area> getAllRegion() {
        List<OriginConfig> originConfigs = originConfigDao.find();
        List<Area> baseAreas = new ArrayList<>();
        // 此处采用的是JDK1.8版本的lambda表达式代替for循环，使得格式上更加优美，便于阅读
        originConfigs.forEach(originConfig ->{
        // 这里会将所有数据以building（建筑）维度的取出来
            baseAreas.add(Area.builder().id(originConfig.getAreaId())
                    .name(originConfig.getConfigName())
                    // JSON.parse出现问题，暂时使用JSONArray.parseObject代替
                    .buildings(Lists.newArrayList((Building) JSONArray.parseObject(originConfig.getConfigBody(), Building.class)))
                    .build());
                }
        );
        // 遍历building（建筑）维度的数据，将其封装为area维度
        Map<String, Area> areaById = new HashMap<>();
        baseAreas.forEach(area -> {
            // 当map中还没有相关area信息时，直接添加进去
            if (!areaById.containsKey(area.getId())){
                areaById.put(area.getId(), area);
            }else {
                // 当map中有相关area信息时，将新的building添加到原area里
                areaById.get(area.getId()).getBuildings().addAll(area.getBuildings());
            }
        });
        // 此时只取map的value即可获取所有area信息
        return Lists.newArrayList(areaById.values());
    }
}
