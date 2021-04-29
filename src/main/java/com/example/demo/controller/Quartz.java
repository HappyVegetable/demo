package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2021/4/6.
 */
public class Quartz extends QuartzJobBean {

    @Autowired
    StudentService studentService;

    public static List<Student> top50Students;
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        top50Students= studentService.getAllStudents();
        System.out.println(context.getTrigger().getKey().getName());
        System.out.println("Tiem："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
