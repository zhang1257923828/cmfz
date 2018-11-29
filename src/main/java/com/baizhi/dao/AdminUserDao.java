package com.baizhi.dao;

import com.baizhi.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminUserDao {
    public AdminUser selectOne(@Param("name") String name, @Param("password") String password);
}
