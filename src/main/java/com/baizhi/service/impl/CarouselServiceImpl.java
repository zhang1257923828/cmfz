package com.baizhi.service.impl;

import com.baizhi.dao.CarouselDao;
import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDao carouselDao;

    @Override
    public Map getByPage(int page, int rows) {
        int start = (page - 1) * rows;
        int end = page * rows;
        List<Carousel> list = carouselDao.getByPage(start, end);
        int count = carouselDao.getCount();
        Map map = new HashMap();
        map.put("rows", list);
        map.put("total", count);

        return map;
    }

    @Override
    public void insert(Carousel carousel) {
        carouselDao.insert(carousel);
    }

    @Override
    public void delete(int id) {
        carouselDao.delete(id);
    }

    @Override
    public Carousel selectOne(int id) {
        return null;
    }

    @Override
    public void update(Carousel carousel) {
        carouselDao.update(carousel);
    }
}
