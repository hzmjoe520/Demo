package com.hzm.ribbonprodemo02.controller;

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

          //模拟超时
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

          return "ribbon 提供端的信息============22222";
      }
}
