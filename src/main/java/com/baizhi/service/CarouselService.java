package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.Map;

public interface CarouselService {

    public Map getByPage(int page, int rows);

    public void insert(Carousel carousel);

    public void delete(int id);

    public Carousel selectOne(int id);

    public void update(Carousel carousel);
}
