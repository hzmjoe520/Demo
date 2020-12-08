package com.hzm.springcloudgatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableCircuitBreaker   //开启熔断
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudGatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayDemoApplication.class, args);
    }

}
