package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getMenu")
    public @ResponseBody
    Map getMenu(Map map) {
        List<Menu> list = menuService.getMenu();
        map.put("list", list);
        return map;
    }
}
