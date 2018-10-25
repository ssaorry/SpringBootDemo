package com.springboot.jingfei.SpringBoot.utils.worksheet;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ExportExcel {
    public static <T> HSSFWorkbook export(HttpServletResponse response, String fileName, LinkedHashMap<String, String> excelHeader, List<T> dataList) {
        // 创建一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();

        // 单元格样式类
        HSSFCellStyle titleStyle = wb.createCellStyle();

        // 设置单元格边框样式
        titleStyle.setBorderTop(BorderStyle.THIN);// 上边框 细边线
        titleStyle.setBorderBottom(BorderStyle.THIN);// 下边框 细边线
        titleStyle.setBorderLeft(BorderStyle.THIN);// 左边框 细边线
        titleStyle.setBorderRight(BorderStyle.THIN);// 右边框 细边线

        // 设置单元格对齐方式
        titleStyle.setAlignment(HorizontalAlignment.CENTER); // 水平居中
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中

        // 设置字体样式
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 15); // 字体高度
        titleFont.setFontName("黑体"); // 字体样式
        titleStyle.setFont(titleFont);

        // 创建一个sheet页
        HSSFSheet sheet = wb.createSheet(fileName);
        // 设置冻结列
        sheet.createFreezePane(excelHeader.size(), 1);
        // 创建标题行
        HSSFRow row = sheet.createRow(0);
        List<String> fieldList = new ArrayList<>(); // 表头字段
        List<String> valueList = new ArrayList<>(); // 表头内容
        for (String key : excelHeader.keySet()) {
            fieldList.add(key);
            valueList.add(excelHeader.get(key));
        }

        for (int i = 0; i < valueList.size(); i++) {
            // 创建单元格
            HSSFCell titleCell = row.createCell(i);
            titleCell.setCellValue(valueList.get(i));
            titleCell.setCellStyle(titleStyle);
            // 每填充一列数据向右移一列
            sheet.autoSizeColumn(i + 1);
        }
        try {
            // 导入数据
            Iterator it = dataList.iterator();
            int index = 1;
            while (it.hasNext()) {
                HSSFRow dataRow = sheet.createRow(index++);
                T t = (T) it.next();
                for (int i = 0; i < fieldList.size(); i++) {
                    HSSFCell dataCell = dataRow.createCell(i);
                    Class clazz = t.getClass();
                    String field = fieldList.get(i);
                    String methodName = "get" + field.substring(0,1).toUpperCase() + field.substring(1,field.length());
                    Method method = clazz.getMethod(methodName, new Class[]{});
                    Object value = method.invoke(t, new Class[]{});
                    dataCell.setCellValue(value.toString());
                    sheet.autoSizeColumn(i + 1);
                }
            }
            // 设置请求
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xls");
            // 打开流
            OutputStream outputStream = response.getOutputStream();
            // HSSFWorkbook写入流
            wb.write(outputStream);
            // 刷新流
            outputStream.flush();
            // 关闭流
            outputStream.close();
            // 关闭工作簿
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }
}
