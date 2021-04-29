package com.example.demo.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2021/4/1.
 */
public class 快速排序 {
    public static void main(String[] args) {
        int array[] = {4, 1, 6, 7, 1, 2, 5, 12, 44};
        int array1[] = {1, 2, 6, 7, 1, 4, 5, 12, 44};
        int left=0;
        int right=array.length-1;
        quickSort(array,left,right);
    }
    public static void quickSort(int[] a,int left,int right) {
    if(left < right) {
        int index = getIndex(a,left,right);
        quickSort(a,left,index-1);
        quickSort(a,index+1,right);
    }
}
    public static int getIndex(int[] a,int left,int right) {
        int tmp = a[left];
        while(left < right) {
            //用while循环，来判断右指针对应的数是否大于tmp，是的话不用交换，直接移动右指针即可
            while(left < right && a[right] >= tmp) {
                right--;
            }
            //顺序执行到这里，肯定是不满足上面的while循环条件，也就是右边的数要小于中间值，此时需要把右边的数换到左边
            a[left] = a[right];
            while(left < right && a[left] <= tmp) {
                left++;
            }
            a[right] = a[left];
        }
        //当循环结束后，左右两边都分好大小，而指针重合位置处却没有值，需要把中间值放进来。
        a[left] = tmp;
        //返回两者相交处。
        return left;
    }
}
