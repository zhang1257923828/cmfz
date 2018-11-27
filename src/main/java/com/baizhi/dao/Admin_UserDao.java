package com.baizhi.dao;

import com.baizhi.entity.Admin_User;
import org.apache.ibatis.annotations.Param;

public interface Admin_UserDao {
    public Admin_User selectOne(@Param("name") String name, @Param("password") String password);
}
