package com.example.demo.test;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.*;
import java.util.function.IntBinaryOperator;

/**
 * Created by Administrator on 2021/4/12.
 */
public class Look {


     static volatile int a = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 50, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
        for (int i = 0; i < 20; i++) {

            int finalI = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {

                    a++;
                    System.out.println(Thread.currentThread().getName() + "::::::" + a + "::" + finalI);

                }
            });
        }

        threadPoolExecutor.shutdown();

        ArrayList arrayList=new ArrayList<>(20);
        arrayList.add(0,false);
        arrayList.add(1,"123");
        arrayList.add(0,222);
        arrayList.set(0,345);

        ListIterator iterator=arrayList.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();

        }

        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
