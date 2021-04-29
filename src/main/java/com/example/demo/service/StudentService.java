package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Score;
import com.example.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2021/3/31.
 */
@Service
public class StudentService {


    @Autowired
    StudentDao studentDao;
    public List<Student> getAllStudents(){

        List<Student> list;
        list=studentDao.getAllStudents();
        return list;
    }


    public Student getStuInfo(int stuId) {

        return studentDao.getInfo(stuId);


    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int addStudentScore(Score score) {


        int status = studentDao.addStudentScore(score);

        return status;


    }


}
