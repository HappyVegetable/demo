package com.example.demo.controller;

/**
 * Created by Administrator on 2021/4/6.
 */
public class 二分查找 {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,22,33,44,55,66,77,88,99,100};
        Boolean bl=false;
        int left=0;
        int right=array.length;

        int searche=99;
        int searcheIndex=0;
        while (!bl){
            int mid=(left+right)/2;
            if(array[mid]==searche){
                searcheIndex=mid;
                bl=true;
            }
            if(array[mid]>searche){
                right=mid-1;
            }else if(array[mid]<searche){
                left=mid+1;
            }

        }
        System.out.println(searcheIndex);
    }
}
