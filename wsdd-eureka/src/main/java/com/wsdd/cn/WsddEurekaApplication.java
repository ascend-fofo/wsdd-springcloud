package com.wsdd.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WsddEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsddEurekaApplication.class, args);
    }

}
