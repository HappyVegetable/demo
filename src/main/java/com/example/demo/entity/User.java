package com.example.demo.entity;

/**
 * Created by Administrator on 2021/4/7.
 */
public class User {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    int userId;
    String userName;
}
