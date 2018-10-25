package com.springboot.jingfei.SpringBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("demo");
        mv.addObject("name","jingfei");
        return mv;
    }
}
