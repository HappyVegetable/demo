package com.example.demo.entity;

import com.example.demo.entity.Score;

import java.util.List;

/**
 * Created by Administrator on 2021/3/31.
 */
public class Student {
    private int stuId;
    private String stuName;
    private List<Score> scoreList;

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
}
