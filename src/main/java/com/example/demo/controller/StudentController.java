package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.RedisUtils;
import com.example.demo.entity.Score;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2021/3/31.
 */
@Controller()
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    //localhost:8080/student/getStuInfo?id=2
    @Autowired
    StudentService studentService;
    @Resource
    private RedisUtils redisUtils;



    @DeleteMapping
    @PutMapping
    @PatchMapping
    @PostMapping
    @GetMapping

    @RequestMapping("/addStudentScore")
    @CrossOrigin
    @ResponseBody
    public String addStudentScore(Score score){
        int status;
        try {
            status=studentService.addStudentScore(score);
            logger.info("插入数据成功 count:"+status);
        }catch (Exception e){
            logger.error("插入数据失败 MEssage:"+e.getMessage());
            status=0;
        }

        if(status>0){
            return JSON.toJSONString("1");
        }else {
            return JSON.toJSONString("0");
        }

    }

    @RequestMapping("/getStuInfo")
    @CrossOrigin
    @ResponseBody
    public String getStuInfo(@RequestParam("id") int stuId) {
        String str=redisUtils.get(stuId+"");
        if (str!=null&&str!=""){
            return str;
        }else{
            Student student=studentService.getStuInfo(stuId);
            redisUtils.set(stuId+"", JSON.toJSONString(student));
            return JSON.toJSONString(student);
        }


    }
    @RequestMapping("/getTop50Students")
    @ResponseBody
    public String getTop50Students(){
        ConcurrentHashMap hashMap =new ConcurrentHashMap();
        hashMap.put("1",1);

        List<Student>  studentList=Quartz.top50Students;

        return JSON.toJSONString(studentList);
    }


    @RequestMapping(value="/uploadFile",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public String upLoadFile(@RequestParam("file") MultipartFile[] files, @RequestParam("stuId")Integer stuId) {
        MultipartFile file;
        String fileName=null;
        if(files[0].getName()!=null){
            //System.out.println(stuId+"___"+file.getName());
            for (int i = 0; i < files.length; i++){
                String path = "d:/uploadFile";//本地路径(服务器路径)
                file = files[i];
                path = path +"/"+stuId+file.getOriginalFilename();
                upload(path,file);
            }}

        return JSON.toJSONString("ok");
    }

    private static void upload(String path, MultipartFile file) {
        FileOutputStream fout = null;
        InputStream in = null;
        try {
            fout=new FileOutputStream(path);
            in=file.getInputStream();
            byte bytes[]=new byte[1024];
            int line;

            while((line=in.read(bytes))!=-1){
                fout.write(bytes,0,line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fout.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
