package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getMenu")
    public @ResponseBody
    List getMenu() {
        List<Menu> list = menuService.getMenu();
        System.out.println("菜单打印" + list);
        return list;
    }
}
