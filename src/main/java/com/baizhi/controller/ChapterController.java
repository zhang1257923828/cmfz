package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

@RequestMapping("/chapter")
@Controller
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/addChapter")
    public void addChapter(Chapter ch, MultipartFile chapter, String title, int id, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");  //webapp当前项目的路径
        File file = new File(realPath + "/upload");
        if (!file.exists()) {
            file.mkdir();
        }
        //给音乐起名字
        String extension = FilenameUtils.getExtension(chapter.getOriginalFilename());
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String newName = s + "." + extension;


        try {
            chapter.transferTo(new File(file.getAbsolutePath(), newName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileUtil.getDuration(new File(file.getAbsolutePath() + "/" + newName));
        long size = chapter.getSize();
        double l = size / 1024.0 / 1024.0;
        System.out.println(l);
        String daxiao = l + "MB";
        //时长
        int length = FileUtil.getDuration(new File(file.getAbsolutePath() + "/" + newName));
        int fen = length / 60;
        int miao = length % 60;
        String shichang = fen + "分" + miao + "秒";

        ch.setParentId(id);
        ch.setTitle(title);
        ch.setSize(daxiao);
        ch.setDuration(shichang);
        ch.setDownPath(newName);
        System.out.println("+++++++++++++++++++++++++++++++++++++" + id + title + daxiao + shichang + newName);
        chapterService.insert(ch);
    }

    @RequestMapping("/download")
    public void download(String url, String title, HttpServletRequest request, HttpServletResponse response) {
        String uploadPath = request.getSession().getServletContext().getRealPath("upload");  //webapp当前项目的路径
        String path = uploadPath + "/" + url;
        File file = new File(path);

        String s = title + "." + "mp3";

        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
