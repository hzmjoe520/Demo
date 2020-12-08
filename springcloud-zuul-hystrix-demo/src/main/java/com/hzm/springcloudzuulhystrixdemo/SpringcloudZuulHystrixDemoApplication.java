package com.hzm.springcloudzuulhystrixdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableZuulProxy
@SpringBootApplication
public class SpringcloudZuulHystrixDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuulHystrixDemoApplication.class, args);
    }

}
