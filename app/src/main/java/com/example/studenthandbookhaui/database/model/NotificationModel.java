package com.example.studenthandbookhaui.database.model;

public class NotificationModel extends BaseModel{
    private String type;
    private String content;
    private String time;

    public NotificationModel() {
    }

    public NotificationModel(String type, String content, String time) {
        this.type = type;
        this.content = content;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
