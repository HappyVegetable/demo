package com.example.demo.test;

/**
 * Created by Administrator on 2021/4/9.
 */
public class Ove  {
    static int num;
    static{
        num+=2;
        System.out.println("静态执行："+num);
    }
     public  Ove(){
        num+=2;
         System.out.println("构造器执行："+num);
    }

    public Ove(String str){
        s(str);
        System.out.println(str);
    }
    public  void s(int a,int b,float c){

    }
    public String s(String str){
        System.out.println(str);
        return "";
    }
    private void s(String a,float c,float d){

    }
}
