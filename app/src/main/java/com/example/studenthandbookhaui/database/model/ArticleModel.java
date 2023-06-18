package com.example.studenthandbookhaui.database.model;

public class ArticleModel extends BaseModel {
    private int id;
    private String name;
    private String content;

    public ArticleModel() {
    }

    public ArticleModel(int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
