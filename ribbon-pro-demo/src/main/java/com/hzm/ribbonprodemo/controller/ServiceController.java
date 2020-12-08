package com.hzm.ribbonprodemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @createTime 2020/12/7 15:18
 */
@RestController
public class ServiceController {

      @GetMapping("/pro")
      public String first(){

          return "ribbon 提供端的信息";
      }
}
