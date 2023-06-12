package com.example.studenthandbookhaui.database.model;

public abstract class BaseModel {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
