package com.hzm.ribboncomdemo.service.impl;

import com.hzm.ribboncomdemo.service.ClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @createTime 2020/12/7 15:24
 */
@Service
public class ClientServiceImpl implements ClientService {

    //ribbon 的负载均衡客户端
    @Autowired
    private LoadBalancerClient loadBalancerClient;



    /**
     *
     * @HystrixCommand - 开启 Hystrix 容错处理的注解。代表当前方法如果出现服务
     调用问题，使用 Hystrix 容错处理逻辑来处理
     * 属性 fallbackMethod - 如果当前方法调用服务，远程服务出现问题的时候，调
    用本地的哪个方法得到托底数据。
     */
    //@HystrixCommand(fallbackMethod = "fallback") 降级
    //熔断
    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            // 默认 20 个;10s 内请求数大于 20 个时就启动熔断器，当请求符合熔断条件时将触发 fallback 逻辑
            @HystrixProperty(name =
                    HystrixPropertiesManager. CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD , value =
                    "10"),
//请求错误率大于 50%时就熔断， 然后 for 循环发起请求， 当请求符合熔断条件时将触发
            @HystrixProperty(name =
                    HystrixPropertiesManager. CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE , value =
                    "50"),
//默认 5 秒;熔断多少秒后去尝试请求
            @HystrixProperty(name =
                    HystrixPropertiesManager. CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS , value =
                    "5000")
    })
    @Override
    public String first() {
        /*
* ServiceInstance 封装了服务的基本信息，如 IP，端口
* 在 Spring Cloud 中，对所有注册到 Eureka Server 中的服务都称为一个
service instance 服务实例。
* 一个服务实例，就是一个有效的，可用的，服务单体实例或集群实例。
* 每个 service instance 都和 spring application name 对应。
* 可以通过 spring application name 查询 service instance
*/
        ServiceInstance si =
                this.loadBalancerClient.choose("RIBBON-PRO");
// 拼接访问服务的 URL http://ip:port/
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost())
                .append(":").append(si.getPort()).append("/pro");
        System.out.println("本次访问的 e service ： 是： " + sb.toString());
        RestTemplate rt = new RestTemplate();
        ParameterizedTypeReference<String> type =
                new ParameterizedTypeReference<String>() {
                };
        ResponseEntity<String> response =
                rt.exchange(sb.toString(), HttpMethod.GET, null, type);
        String result = response.getBody();

        return result;
    }

    // 本地容错方法，只有远程服务调用过程出现问题的时候，才会调用此方法，获取
     //托底数据。保证服务完整性。

    //讲解方法
     private String fallback(){

           return "服务降级的方法返回的拖地数据";
     }
}
