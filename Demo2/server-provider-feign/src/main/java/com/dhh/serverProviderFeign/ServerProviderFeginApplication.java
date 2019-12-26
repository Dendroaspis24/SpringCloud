package com.dhh.serverProviderFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServerProviderFeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerProviderFeginApplication.class, args);
    }

}
