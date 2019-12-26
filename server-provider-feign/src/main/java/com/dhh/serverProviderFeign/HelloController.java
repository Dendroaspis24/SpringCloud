package com.dhh.serverProviderFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//服务消费者controller 调用helloremote接口，helloremote接口远程调用服务提供者hellocontroller中的具体方法
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @GetMapping("/{name}")
    public String index(@PathVariable("name") String name){
        return helloRemote.hello(name+"附加");
    }

    @GetMapping("/getAge")
    public String getAge(@RequestParam int age1){
        return helloRemote.getAge(age1);
    }
}
