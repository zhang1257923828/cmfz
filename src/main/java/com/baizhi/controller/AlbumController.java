package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/selectAll")
    public @ResponseBody
    List selectAll() {

        return albumService.selectAll();
    }

/*@RequestMapping("/addAlbum")
    public @ResponseBody
    boolean addAlbum(Album album, MultipartFile chapter, HttpServletRequest request) {
    System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        try {
            // 获取文件的名字
            String fileName = chapter.getOriginalFilename();
            // System.out.println("文件上传的名字" + fileName);
            // 文件重新命名
            // fileName = new Date().getTime() + "_" + fileName;
            // 把接收到的文件转换成磁盘文件
            // wenjian.transferTo(new
            // File("F:\\Tomcat\\apache-tomcat-7.0.72\\webapps\\SpringmvcAuction\\wenjian"+fileName));
            // 根据文件夹名字获取绝对路径
            String realPath = request.getRealPath("img");
            chapter.transferTo(new File(realPath + "\\" + fileName));
            album.setCoverImg(fileName);
            albumService.insert(album);
            System.out.println("++++++++++++++++++"+fileName);
            return true;
        } catch (Exception e) {
            return false;
        }

    }*/

    @RequestMapping("/addAlbum")
    public @ResponseBody
    boolean addAlbum(Album album, MultipartFile pic, HttpServletRequest request) throws IOException {
        String fileName = pic.getOriginalFilename();
        fileName = new Date().getTime() + "_" + fileName;
        String realPath = request.getRealPath("img");
        pic.transferTo(new File(realPath + "\\" + fileName));
        try {
            album.setCoverImg(fileName);
            System.out.println(album.getTitle());
            albumService.insert(album);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
