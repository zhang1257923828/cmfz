package com.baizhi.controller;

import com.baizhi.entity.AdminUser;
import com.baizhi.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/login")
    public String log(HttpSession session, AdminUser admin_user, String code) {
        String sessionkaptcha = (String) session.getAttribute("code");
        admin_user = adminUserService.selectOne(admin_user.getName(), admin_user.getPassword());
        System.out.println(admin_user + "*********************");
        if (admin_user != null && sessionkaptcha.equalsIgnoreCase(code)) {
            session.setAttribute("admin_user", admin_user);
            return "redirect:/main/main.jsp";
        } else {
            return "login";
        }


    }

}
