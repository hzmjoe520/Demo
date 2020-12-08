package com.hzm.ribboncomdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker  //开启服务降级功能
@EnableEurekaClient
@SpringBootApplication
public class RibbonComDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonComDemoApplication.class, args);
    }

}
