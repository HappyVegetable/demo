package com.example.demo.controller;


import java.util.concurrent.*;

/**
 * Created by Administrator on 2021/4/1.
 */

public class ThreadPoolExecutor池 {
    public static void main(String[] args) {

        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 20, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable()
            {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();

                        //Thread.interrupted();
                        //String out = doSome(Thread.currentThread().getName());

                        String take = synchronousQueue.take();
                        String out = doSome(take);

                        System.out.println(Thread.currentThread().getName() + "___" + out);

                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            try {
                synchronousQueue.put(i + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static String doSome(String input) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + ":" + (System.currentTimeMillis() / 1000);
        return output;
    }

}
