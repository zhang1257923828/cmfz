package com.baizhi.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Controller
public class KaptchaController {
    @Autowired
    private Producer producer;

    @RequestMapping("/getKaptcha")
    public void getKaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        //生成文本内容
        String text = producer.createText();
        //把文本内容放入session
        session.setAttribute("code", text);
        BufferedImage image = producer.createImage(text);
        ImageIO.write(image, "jpg", response.getOutputStream());


    }
}
