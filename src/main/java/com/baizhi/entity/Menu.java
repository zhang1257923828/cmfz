package com.baizhi.entity;

import lombok.Data;

@Data
public class Menu {
    private int id;
    private String title;
    private String iconCls;
    private int parent_id;
    private String url;

    public Menu() {
    }

    public Menu(int id, String title, String iconCls, int parent_id, String url) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.parent_id = parent_id;
        this.url = url;
    }
}
