package com.example.demo.controller;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2021/4/1.
 */
public class 选择排序 {
    public static void main(String[] args) {
        int a[] = {1, 2, 0, 3, 4};
        int a2[] = {1, 2, 0, 3, 4, 3};
        int a3[] = {1, 2, 0, 3, 4, 3};
        int index, current, mxi, temp;

        /*
        选择排序
         */
        for (int i = 0; i < a.length - 1; i++) {
            mxi = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[mxi]) {
                    mxi = j;
                }
            }
            if (mxi != i) {
                temp = a[i];
                a[i] = a[mxi];
                a[mxi] = temp;
            }
        }


        /*
        插入排序
         */
        for (int i = 1; i < a2.length; i++) {
            index = i - 1;
            current = a2[i];
            while (index >= 0 && current > a2[index]) {
                a2[index + 1] = a2[index];
                index--;
            }
            a2[index + 1] = current;
        }
        /**
         * 快速排序
         */
        int[] a4=quick(a3,0,a3.length-1);
        for (int i = 0; i <a4.length ; i++) {
            System.out.println(a4[i]);
        }

    }
    public static int[] quick(int[] a,int left,int right){
        if(left>right){
            return null;
        }
        int temp=a[left];
        int i=left;
        int j=right;
        while (i!=j){
            while (a[j]>=temp&&j>j--){
                j--;
            }
            while (a[i]<=temp&&j>i++){
                i++;
            }
            if(j>i){
                int t=a[i];
                a[i]=a[j];
                a[j]=t;

            }
        }
        a[left]=a[i];
        a[i]=temp;
        quick(a,left,i-1);
        quick(a,i+1,right);
        return a;
    }
}
