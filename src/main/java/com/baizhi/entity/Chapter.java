package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    private int id;
    private int parentId;
    private String title;
    private String size;
    private String duration;
    private String downPath;
    @DateTimeFormat(pattern = "YYYY-mm-dd")
    @JSONField(format = "YYYY-mm-dd")
    private Data uploadDate;
}
