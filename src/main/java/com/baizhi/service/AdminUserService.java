package com.baizhi.service;

import com.baizhi.entity.AdminUser;

public interface AdminUserService {
    public AdminUser selectOne(String name, String password);
}
