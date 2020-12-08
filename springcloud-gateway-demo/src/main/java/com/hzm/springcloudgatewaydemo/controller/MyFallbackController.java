package com.hzm.springcloudgatewaydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @createTime 2020/12/8 16:24
 *
 * 网关处理熔断机制
 */

@RestController
public class MyFallbackController {

      @GetMapping("/fallback")
       public Object  fallback(){

               return  "这是网关处理的降级处理!";
          }
}
