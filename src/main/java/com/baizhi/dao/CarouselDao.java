package com.baizhi.dao;

import com.baizhi.entity.Carousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarouselDao {
    public List<Carousel> getByPage(@Param("start") int start, @Param("end") int end);

    public int getCount();

    public void insert(Carousel carousel);

    public void delete(int id);

    public Carousel selectOne(int id);

    public void update(Carousel carousel);
}
