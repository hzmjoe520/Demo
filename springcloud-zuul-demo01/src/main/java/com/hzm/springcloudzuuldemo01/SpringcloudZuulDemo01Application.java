package com.hzm.springcloudzuuldemo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SpringcloudZuulDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuulDemo01Application.class, args);
    }

}
