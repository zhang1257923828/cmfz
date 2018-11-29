package com.baizhi.dao;

import com.baizhi.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {
    public List<Menu> getMenu();
}
