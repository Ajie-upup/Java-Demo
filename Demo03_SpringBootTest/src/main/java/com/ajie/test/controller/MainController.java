package com.ajie.test.controller;

import com.ajie.test.dao.StudentDao;
import com.ajie.test.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ajie
 * @date 2023/7/12
 * @description:
 */
@RestController
public class MainController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/testJdbc", method = {RequestMethod.GET, RequestMethod.POST})
    public String testJdbc() {
        List<Student> students = studentDao.selectNameAndClass();
        for (Student student : students) {
            System.out.println(student);
        }
        return "success";
    }

}
