package com.dhh.serverProviderFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //注解 fegin客户端 将远程请求映射为本地的java方法调用
@EnableHystrix//注解 开启断路器功能
public class ServerProviderFeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerProviderFeginApplication.class, args);
    }

}
