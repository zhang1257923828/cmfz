package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("main")
@Controller
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @RequestMapping("/getByPage")
    public @ResponseBody
    Map getByPage(int page, int rows) {
        System.out.println(carouselService.getByPage(page, rows));
        return carouselService.getByPage(page, rows);
    }

    @RequestMapping("/delete")
    public @ResponseBody
    boolean delete(int id) {
        try {
            carouselService.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/add")
    public @ResponseBody
    boolean add(Carousel carousel) {
        try {
            carouselService.insert(carousel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/update")
    public @ResponseBody
    boolean update(Carousel carousel) {
        try {
            carouselService.update(carousel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
