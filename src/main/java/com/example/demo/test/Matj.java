package com.example.demo.test;

/**
 * Created by Administrator on 2021/4/23.
 */
public class Matj {
    public static void main(String[] args) {
        int a,b,c;
        int num=710;
        System.out.println(num/100);
        System.out.println((num/10)%10);
        System.out.println((num%10));
        for (int i = 100; i <1000 ; i++) {
            a=i/100;
            b=(i/10)%10;
            c=(i%10)%10;
            if((c>a&&a>b)&&((a+b+c)==(a*b*c))){
                System.out.println(i);
            }
        }
    }
}
