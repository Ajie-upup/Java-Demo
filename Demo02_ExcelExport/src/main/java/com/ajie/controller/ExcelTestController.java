package com.ajie.controller;

import com.ajie.pojo.User;
import com.ajie.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ajie
 * @date 2023/7/5
 * @description:
 */
@RestController
@RequestMapping("/test")
public class ExcelTestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserList")
    public List<User> queryUserList() {
        return userService.list();
    }


    @GetMapping(value = "/exportExcel")
    public void exportExcel(HttpServletResponse response, String fileName) throws Exception {
        // 1. 查询需要导入到 excel 表中的数据
        List<User> userList = userService.list();
        List<String> usernames = userList.stream().map(User::getName).collect(Collectors.toList());
        HSSFWorkbook workbook = new HSSFWorkbook();

        exportExcel(workbook, 0, "1", usernames);
        exportExcel(workbook, 1, "2", usernames);

        response.setContentType("application/octet-stream;charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void exportExcel(HSSFWorkbook workbook, int sheetNum, String sheetTitle,
                                   List<String> result) throws Exception {

        // 创建一个sheet页
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);//设置sheet页标题
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("test");
        // 遍历集合数据，产生数据行
        if (result != null) {
            int rowIndex = 1;
            for (String str : result) {
                row = sheet.createRow(rowIndex);
                cell = row.createCell(0);
                cell.setCellValue(str);
                rowIndex++;
            }
        }
    }


}


