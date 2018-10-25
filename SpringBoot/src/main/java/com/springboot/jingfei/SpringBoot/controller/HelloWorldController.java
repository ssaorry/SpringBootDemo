package com.springboot.jingfei.SpringBoot.controller;

import com.springboot.jingfei.SpringBoot.annotation.SysLog;
import com.springboot.jingfei.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RestController注解返回json字符串
 * RestController注解是被Controller和ResponseBody注解修饰的
 */

@RestController
public class HelloWorldController {

    @Autowired
    private UserService userService;

	@RequestMapping("hello")
    @SysLog(name = "index方法", value="系统登录入口")
	public String index() {
        return "Hello World!";
    }

    @RequestMapping("export")
    @SysLog(name = "exportExcel", value="导出Excel")
    public String exportExcel(HttpServletRequest request, HttpServletResponse response) {
        userService.exportExcel(response);
        return "OK";
    }
}
