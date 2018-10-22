package com.library.libraryproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.libraryproject.entity.OriginConfig;

@Mapper
public interface OriginConfigDao {
    int insert(@Param("originConfig") OriginConfig originConfig);

    int insertSelective(@Param("originConfig") OriginConfig originConfig);

    int insertList(@Param("originConfigs") List<OriginConfig> originConfigs);

    int update(@Param("originConfig") OriginConfig originConfig);
}
