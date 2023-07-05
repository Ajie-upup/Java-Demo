package com.ajie.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.ajie.mapper.UserMapper;
import com.ajie.pojo.User;
import com.ajie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author ajie
 * @date 2023/7/5
 * @description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    //创建单个excel的方法，多个excel的话，加几个这种方法就行
    @Override
    public List<Object> createExcel(String fileName) throws Exception {
        List<Object> result = new ArrayList<>();
        List<User> userList = userMapper.selectList(null);

        ExcelWriter excelWriter = ExcelUtil.getWriter();
        //添加表头对应的数据列
        excelWriter.addHeaderAlias("id", "编号");
        excelWriter.addHeaderAlias("name", "姓名");

        excelWriter.write(userList, true);
        //写入流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        excelWriter.flush(out);
        //关闭
        excelWriter.close();
        result.add(out);
        result.add(fileName);
        return result;
    }

    //循环导入excel的流，准备在Controller层生成zip包
    public void writeZos(List<ByteArrayOutputStream> bosList, ZipOutputStream zos, List<String> excelName) throws IOException {
        for (int i = 0; i < bosList.size(); i++) {
            //将多个excel都转成字节流写入
            zos.putNextEntry(new ZipEntry(excelName.get(i)));
            byte[] excelStream = bosList.get(i).toByteArray();
            zos.write(excelStream);
            //记得关闭
            zos.closeEntry();
        }
    }
}
