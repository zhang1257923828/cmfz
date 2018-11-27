package com.baizhi.service.impl;

import com.baizhi.dao.AdminUserDao;
import com.baizhi.entity.AdminUser;
import com.baizhi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public AdminUser selectOne(String name, String password) {

        return adminUserDao.selectOne(name, password);
    }
}
