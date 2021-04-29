package com.example.demo.controller;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2021/4/8.
 */
public class Thread1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + finalI + "次执行，线程：" + Thread.currentThread().getName() + "   号");
                }
            });
        }
        executorService.shutdown();
        ExecutorService exec2 = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            exec2.submit(new Runnable() {
                @Override
                public void run() {

                    System.out.println("第" + finalI + "次执行，线程：" + Thread.currentThread().getName() + "   号");

                }
            });


        }

        ExecutorService exec3=new ThreadPoolExecutor(10,15,100, TimeUnit.SECONDS,new PriorityBlockingQueue<>(10));
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            exec3.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("第" + finalI + "次执行，线程：" + Thread.currentThread().getName() + "   号");


            }
        });
    }}
}
