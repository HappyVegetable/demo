package com.example.demo.test;

import javax.xml.soap.SAAJResult;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2021/4/20.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        myCopy("C:\\Users\\Administrator.USER-20190504DJ\\Desktop\\1-03.sql","C:\\Users\\Administrator.USER-20190504DJ\\Desktop\\0420.bak.txt");
    }
    static boolean copyFiles(String sourceFileName,String destFileName){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream=new FileInputStream(sourceFileName);
            fileOutputStream=new FileOutputStream(destFileName);
            int line;
            byte[] bytes=new byte[1024];
            while ((line=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");
        } catch (IOException e) {
            System.out.println("备份失败");

        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println("关闭输出流失败");
                }
            }
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println("关闭输入流失败");
                }
            }

        }


        return true;
    }


    public static  void myCopy(String a1,String a2) throws IOException {
        FileInputStream fi=new FileInputStream(a1);
        FileOutputStream fo=new FileOutputStream(a2);
        byte[] bytes=new byte[1024];
        int line;
        while ((line=fi.read(bytes))!=-1){
            fo.write(bytes,0,line);
        }
        fo.close();
        fi.close();

    }
}
