package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private int id;
    private String title;
    private String coverImg;
    private int count;
    private String score;
    private String author;
    private String broadCast;
    private String brief;
    @DateTimeFormat(pattern = "YYYY-mm-dd")
    @JSONField(format = "YYYY-mm-dd")
    private Data publishDate;
    private List<Chapter> children;
}
