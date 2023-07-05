package com.ajie.controller;

import com.ajie.pojo.User;
import com.ajie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author ajie
 * @date 2023/7/4
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<User> selectAll() {
        List<User> list = userService.list();
        System.out.println(list);
        return list;
    }

}
