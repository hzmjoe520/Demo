package com.hzm.feignseviceprodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FeignSeviceProDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignSeviceProDemoApplication.class, args);
    }

}
