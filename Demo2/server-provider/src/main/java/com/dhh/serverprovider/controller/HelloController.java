package com.dhh.serverprovider.controller;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/hello")
public class HelloController {

    //服务提供者的controller方法
    @GetMapping("/")
    public String Hello(@RequestParam String name){
        return "HELLO!"+name+ DateFormatUtils.format(new Date(),"yyyyMMdd")+getAge(12);
    }

    @GetMapping("/getAge")
    public String getAge(@RequestParam int age){
        return "tim今年"+age+"岁";
    }
}
