package com.example.demo.controller;

import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2021/4/6.
 */
public class SingtonThread {
    public static void main(String[] args) {
        ExecutorService executorService =Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("index"+ finalI +Thread.currentThread().getName() + "正在执行任务");
                }
            });
        }
        executorService.shutdown();
        System.out.println();
        ExecutorService executorService1=Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            executorService1.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("index"+ finalI +Thread.currentThread().getName() + "正在执行任务");
                }
            });
        }
        executorService1.shutdown();
        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 5; i++) {
            scheduledExecutorService.schedule(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("时间："+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "正在执行任务");
                    return "111";
                }
            }, 3, TimeUnit.SECONDS);
        }
        scheduledExecutorService.shutdown();
        ScheduledExecutorService scheduledExecutorService1=Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService1.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1时间："+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "正在执行任务");
            }
        },0,3,TimeUnit.HOURS);

    }

}
