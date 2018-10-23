package com.library.libraryproject.service;

import java.util.List;
import com.library.libraryproject.entity.OriginConfig;
import com.library.libraryproject.entity.dto.Area;

public interface OriginConfigService{

    int insert(OriginConfig originConfig);

    int insertSelective(OriginConfig originConfig);

    int insertList(List<OriginConfig> originConfigs);

    int update(OriginConfig originConfig);

    List<Area> getAllRegion();
}
