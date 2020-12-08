package com.hzm.ribbonprodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RibbonProDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonProDemoApplication.class, args);
    }

}
