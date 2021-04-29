package com.example.demo.test;


/**
 * Created by Administrator on 2021/4/12.
 */
public class A {
    private A() {
    };
    private  static class B{
        private static final A a=new A();
    }

    public static  A getA() {

        return B.a;
    }

}