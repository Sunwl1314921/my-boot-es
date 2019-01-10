package com.stream.source.user.services;

//先定义两个DTO
public class Message {
    private String message;
    private Integer all;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

}