package com.library.libraryproject.dao;


import com.library.libraryproject.entity.Param.RecoverUserStatusParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.library.libraryproject.entity.User;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    int insert(@Param("user") User user);

    int insertSelective(@Param("user") User user);

    int insertList(@Param("users") List<User> users);

    int update(@Param("user") User user);

    User findByUserId(@Param("userId")Integer userId);

    List<User> find();

    int deleteByUserId(@Param("userId")Integer userId);

    User findUserByNumberAndPassword(@Param("user")User user);

    int updateUsersStatus(@Param("param") RecoverUserStatusParam param);


}
