package com.hzm.ribbonprodemo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonProDemo02Application {

    public static void main(String[] args) {
        SpringApplication.run(RibbonProDemo02Application.class, args);
    }

}
