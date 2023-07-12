package com.ajie.test.dao.impl;

import com.ajie.test.dao.StudentDao;
import com.ajie.test.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ajie
 * @date 2023/7/12
 * @description:
 */
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> selectNameAndClass() {
        String sql = " select name, class_id from student ";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }
}
