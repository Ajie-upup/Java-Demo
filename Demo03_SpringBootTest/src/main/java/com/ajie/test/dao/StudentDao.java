package com.ajie.test.dao;

import com.ajie.test.domain.Student;

import java.util.List;

/**
 * @author ajie
 * @date 2023/7/12
 * @description:
 */
public interface StudentDao {


    List<Student> selectNameAndClass();


}
