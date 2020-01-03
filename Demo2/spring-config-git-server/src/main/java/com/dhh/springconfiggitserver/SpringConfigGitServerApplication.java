package com.dhh.springconfiggitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringConfigGitServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigGitServerApplication.class, args);
    }

}
