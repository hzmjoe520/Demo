package com.hzm.feignservicecomdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 *  @EnableCircuitBreaker - 在 Openfeign 开发的 application client 应用的启动类中，
不需要使用此注解开启容错处理逻辑。
 * Openfeign 的启动器 spring-cloud-starter-openfeign 中，依赖的是 Hystrix 相关
jar 包，不是完整的 spring-cloud-starter-netflix-hystrix 启动器。
 * 如果使用此注解，在启动的时候，会抛出 ClassNotFoundException。
 *
 *  如果在openfeign使用Hystrix Dashboard 和Acturor则引入依赖以后可添加
 *  @EnableCircuitBreaker
 *  @EnableHystrixDashboard
 */
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignServiceComDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignServiceComDemoApplication.class, args);
    }

}
