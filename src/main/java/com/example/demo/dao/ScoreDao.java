package com.example.demo.dao;

import com.example.demo.entity.Score;

/**
 * Created by Administrator on 2021/3/31.
 */
public interface ScoreDao {
    Score getScore(int stuId);
}
