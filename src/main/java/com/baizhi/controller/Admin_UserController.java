package com.baizhi.controller;

import com.baizhi.entity.Admin_User;
import com.baizhi.service.Admin_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Admin_UserController {
    @Autowired
    private Admin_UserService admin_userService;

    @RequestMapping("/login")
    public String log(HttpSession session, Admin_User admin_user, String code) {
        String sessionkaptcha = (String) session.getAttribute("code");
        admin_user = admin_userService.selectOne(admin_user.getName(), admin_user.getPassword());
        System.out.println(admin_user + "*********************");
        if (admin_user != null && sessionkaptcha.equalsIgnoreCase(code)) {
            session.setAttribute("admin_user", admin_user);
            return "redirect:/main/main.jsp";
        } else {
            return "login";
        }


    }

}
