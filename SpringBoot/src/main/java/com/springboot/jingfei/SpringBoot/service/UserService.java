package com.springboot.jingfei.SpringBoot.service;

import com.springboot.jingfei.SpringBoot.bean.User;
import com.springboot.jingfei.SpringBoot.dao.UserDao;
import com.springboot.jingfei.SpringBoot.utils.worksheet.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUserList() {
        return userDao.getUserList();
    }

    public void exportExcel(HttpServletResponse response) {
        List<User> userList = new ArrayList<>();
        userList.add(new User.Builder().setId(1).setName("jingfei").setAge(23).setSex("m").build());
        userList.add(new User.Builder().setId(2).setName("xufei").setAge(23).setSex("m").build());
        userList.add(new User.Builder().setId(3).setName("zhuangmeng").setAge(23).setSex("m").build());
        userList.add(new User.Builder().setId(4).setName("lvlutao").setAge(23).setSex("m").build());
        userList.add(new User.Builder().setId(5).setName("wangning").setAge(23).setSex("w").build());
        LinkedHashMap<String, String> excelHeader = new LinkedHashMap<>();
        excelHeader.put("id", "序号");
        excelHeader.put("name", "姓名");
        excelHeader.put("age", "年纪");
        excelHeader.put("sex", "性别");
        ExportExcel.export(response, "jingfei", excelHeader, userList);
    }
}
