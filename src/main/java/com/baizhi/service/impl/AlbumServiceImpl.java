package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public List<Album> selectAll() {
        List<Album> list = albumDao.selectAll();
        System.out.println(list);
        return list;
    }

    @Override
    public void insert(Album album) {
        albumDao.insert(album);
    }
}
