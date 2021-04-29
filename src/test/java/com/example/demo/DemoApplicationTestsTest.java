package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2021/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class DemoApplicationTestsTest {

    @Resource
    private RedisUtils redisUtils;

    @Test
    public void set() {
        redisUtils.set("lishuo", "李硕");
    }

    @Test
    public void get() {
        String value = redisUtils.get("lishuo");
        System.out.println(value);
    }
}