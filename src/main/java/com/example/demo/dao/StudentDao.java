package com.example.demo.dao;

import com.example.demo.entity.Score;
import com.example.demo.entity.Student;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2021/3/31.
 */
public interface StudentDao {

    /**
     *
     * @param stuId
     * @return
     */
     Student getInfo(int stuId);

    /**
     * 获取所有学生信息
     * @return List<Student>
     * @by 李硕
     */
      List<Student> getAllStudents();

     /**
      *
      * @param score
      * @return
     */
     int addStudentScore(Score score);


}
