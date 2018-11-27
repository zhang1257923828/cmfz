package com.baizhi.service;

import com.baizhi.entity.Admin_User;

public interface Admin_UserService {
    public Admin_User selectOne(String name, String password);
}
