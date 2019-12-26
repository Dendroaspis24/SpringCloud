package com.dhh.serverProviderFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.loading.PrivateClassLoader;


//调用服务提供者的具体方法
@FeignClient(name = "server-provider")//注解指定这个接口所要调用的服务名称
public interface HelloRemote {

    final static String APIURL = "/hello";//若对应一个controller路径 可以定义变量统一管理
    @GetMapping(APIURL+"/")//注：此类中的方法和远程服务中 Contoller 中的方法名和参数类型.参数名需保持一致
    //远程controller中该方法完整地址/hello/
    String hello(@RequestParam String name);

    @GetMapping(APIURL+"/getAge")
    //将age 替换成  age1 会报错,因此参数名与远程接口的参数名需保持一致
    String getAge(@RequestParam int age);
}
