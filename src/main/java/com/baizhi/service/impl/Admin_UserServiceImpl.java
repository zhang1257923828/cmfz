package com.baizhi.service.impl;

import com.baizhi.dao.Admin_UserDao;
import com.baizhi.entity.Admin_User;
import com.baizhi.service.Admin_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Admin_UserServiceImpl implements Admin_UserService {
    @Autowired
    private Admin_UserDao admin_userDao;

    @Override
    public Admin_User selectOne(String name, String password) {

        return admin_userDao.selectOne(name, password);
    }
}
