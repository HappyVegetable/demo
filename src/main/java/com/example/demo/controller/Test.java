package com.example.demo.controller;

import com.example.demo.test.Ove;
import org.apache.poi.ss.formula.functions.T;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2021/4/9.
 */
public class Test {
    public static Test t2=new Test(1);

    {
        System.out.println("构造1");
    };
    Test(){
        System.out.println("构造2");
    };
    Test( int i){
        System.out.println("构造3");
    };


    static {
        System.out.println("静态");
    };


    public static Test t1=new Test();
    public static void main(String[] args) throws InterruptedException {
        Test t3=new Test();
        Stack stack= new Stack();
        Vector vector=new Vector();

        stack.add(1);
        stack.add(2);
        for (int i = 0; i <stack.size() ; i++) {
            Thread.sleep(1000);
            System.out.println(stack.get(i));
        }

    }

}
