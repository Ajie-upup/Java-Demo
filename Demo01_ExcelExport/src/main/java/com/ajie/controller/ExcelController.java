package com.ajie.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.ajie.pojo.User;
import com.ajie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * @author ajie
 * @date 2023/7/4
 * @description:
 */
@RestController
@RequestMapping("/test")
public class ExcelController {

    @Autowired
    private UserService userService;

    /**
     * 根据传递的文件名生成文件(只有一个 sheet 页面)
     *
     * @param tableName 文件名称
     */
    @RequestMapping(value = "/excel", method = {RequestMethod.GET, RequestMethod.POST})
    public void huToolExcel(HttpServletResponse response, String tableName) {
        String destFilePath = tableName + ".xlsx";
        ExcelWriter excelWriter = ExcelUtil.getBigWriter(destFilePath);
        // 设置表头
        excelWriter.addHeaderAlias("id", "编号");
        excelWriter.addHeaderAlias("name", "姓名");
        // 从数据库中获取数据
        List<User> userList = userService.list();

        // 修改表 sheet 命名
        excelWriter.renameSheet("test1");
        // 生成数据
        excelWriter.write(userList, true);

        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + tableName + ".xlsx");
        try {
            ServletOutputStream out = response.getOutputStream();
            excelWriter.flush(out, true);
            excelWriter.close();
            IoUtil.close(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据传递的文件名生成文件(只有一个 sheet 页面)
     *
     * @param tableName 文件名称
     */
    @RequestMapping(value = "/excel2", method = {RequestMethod.GET, RequestMethod.POST})
    public void huToolExcel2(HttpServletResponse response, String tableName) {
        String destFilePath = tableName + ".xlsx";

        ExcelWriter writer = new ExcelWriter(false,destFilePath);
        // 设置表头
        writer.addHeaderAlias("id", "编号");
        writer.addHeaderAlias("name", "姓名");
        // 从数据库中获取数据
        List<User> userList = userService.list();

        // 修改表 sheet 命名
        writer.renameSheet("test1");
        // 生成数据
        writer.write(userList, true);
        // 设置自动宽度
        writer.autoSizeColumnAll();

        writer.setSheet("test2");

//        writer.write(userList, true);
        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + tableName + ".xlsx");
        try {
            ServletOutputStream out = response.getOutputStream();
            writer.flush(out, true);
            writer.close();
            IoUtil.close(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
