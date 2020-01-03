package com.dhh.springconfiggitclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
@RefreshScope //开启更新机制 启动后Post访问http://localhost:13000/actuator/refresh 更新文件至最新版本
//缺点：每次更新配置文件都需要执行一次请求
public class TestController {
    @Value("${dhh.hello:error}")//获取yml文件中属性的值。解决方案：webhook
    private String profile;

    @RequestMapping("/info")
    public Mono<String> getInfo(){
        return Mono.justOrEmpty(profile);
    }
}
