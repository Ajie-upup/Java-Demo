package com.ajie.test.dao;

import com.ajie.test.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/7/12
 * @description:
 */
public interface StudentDao {


    List<Student> selectNameAndClass();


    Map<String, Object> selectById(String id);

    String selectNameById(String id);
}
