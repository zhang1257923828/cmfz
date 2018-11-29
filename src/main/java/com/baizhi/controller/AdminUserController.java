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
    public String log(HttpSession session, AdminUser adminuser, String code) {
        String sessionkaptcha = (String) session.getAttribute("code");
        adminuser = adminUserService.selectOne(adminuser.getName(), adminuser.getPassword());
        System.out.println(adminuser + "*********************");
        if (adminuser != null && sessionkaptcha.equalsIgnoreCase(code)) {
            session.setAttribute("admin_user", adminuser);
            return "redirect:/main/main.jsp";
        } else {
            return "login";
        }


    }

}
