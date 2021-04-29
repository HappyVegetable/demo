package com.example.demo.controller;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2021/4/1.
 */
public class 有序线程池 implements Runnable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        有序线程池 t=new 有序线程池();
        t.run();
        FutureTask future = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("异步任务执行…");
                Thread.sleep(2000);
                System.out.println("过了很久很久…");
                return "异步任务完成";
            }


        });
        for (int i = 0; i <5 ; i++) {
            new Thread(future).start();
            System.out.println(Thread.currentThread().getId()+" 继续其他任务…");
            Thread.sleep(1000);

            System.out.println(Thread.currentThread().getId()+"获取异步任务结果：{}"+future.get());
        }


        SynchronousQueue synchronousQueue = new SynchronousQueue();
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i <10 ; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                semaphore.acquire();
                                Integer name= (Integer) synchronousQueue.take();
                                System.out.println(Thread.currentThread().getName()+"__"+name);
                                semaphore.release();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
            ).start();
        }
        for (int i = 0; i <10 ; i++) {
            try {
                synchronousQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId()+"实现");
    }
}
