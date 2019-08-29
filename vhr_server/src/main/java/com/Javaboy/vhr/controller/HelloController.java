package com.Javaboy.vhr.controller;

import com.Javaboy.vhr.bean.Salary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello1(){
        return "/employee/basic/hello";
    }


    @GetMapping("/employee/advanced/**")
    public String hello2(){
        return "/employee/advanced/**";
    }
}
