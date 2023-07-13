package com.ajie.test.controller;

import com.ajie.test.dao.StudentDao;
import com.ajie.test.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @RequestMapping(value = "/testQueryMap", method = {RequestMethod.GET, RequestMethod.POST})
    public String testQueryMap(HttpServletRequest request) {
        String id = request.getParameter("id");
        Map<String, Object> studentInfo = studentDao.selectById(id);
        String name = (String) studentInfo.get("name");
        Integer age = (Integer) studentInfo.get("age");
        System.out.println(name + " " + age);
        return "success";
    }


}
