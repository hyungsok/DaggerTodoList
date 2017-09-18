package com.mangoplate.codingtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by hyungsoklee on 2017. 7. 3..
 */

public class Todo {
    @SerializedName("Content")
    private String content;

    @SerializedName("ID")
    private int id;

    @SerializedName("CreatedAt")
    private Date createdAt;

    @SerializedName("UpdatedAt")
    private Date updatedAt;

    public Todo(String content) {
        this.content = content;
    }

    public Todo(String content, int id, Date createdAt, Date updatedAt) {
        this.content = content;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        this.id = ID;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
}
