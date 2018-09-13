package com.library.LibraryProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.LibraryProject.entity.Manager;

@Mapper
public interface ManagerDao {
    int insert(@Param("manager") Manager manager);

    int insertSelective(@Param("manager") Manager manager);

    int insertList(@Param("managers") List<Manager> managers);

    int update(@Param("manager") Manager manager);
}
