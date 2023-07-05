package com.ajie.service;

import com.ajie.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author ajie
 * @date 2023/7/5
 * @description:
 */
public interface UserService extends IService<User> {

    public List<Object> createExcel(String fileName) throws Exception;
}
