package com.hzm.springcloudconfigclientdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @createTime 2020/12/7 23:05
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${name}")
     private String name;

     @GetMapping("/get")
       public String getConfig(){

             return  "获取到的name========"+name;
       }
}
