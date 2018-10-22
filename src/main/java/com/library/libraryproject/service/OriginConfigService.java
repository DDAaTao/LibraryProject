package com.library.libraryproject.service;

import java.util.List;
import com.library.libraryproject.entity.OriginConfig;
public interface OriginConfigService{

    int insert(OriginConfig originConfig);

    int insertSelective(OriginConfig originConfig);

    int insertList(List<OriginConfig> originConfigs);

    int update(OriginConfig originConfig);
}
