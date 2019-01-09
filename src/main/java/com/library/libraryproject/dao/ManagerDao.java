package com.library.libraryproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.libraryproject.entity.Manager;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ManagerDao {
    int insert(@Param("manager") Manager manager);

    int insertSelective(@Param("manager") Manager manager);

    int insertList(@Param("managers") List<Manager> managers);

    int update(@Param("manager") Manager manager);

    List<Manager> find();

    Manager findByManagerAccountAndManagerPwd(@Param("managerAccount")String managerAccount,@Param("managerPwd")String managerPwd);

    int deleteByManagerAccount(@Param("managerAccount")String managerAccount);

}
