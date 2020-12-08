package com.hzm.ribboncomdemo.controller;

import com.hzm.ribboncomdemo.service.ClientService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @createTime 2020/12/7 15:29
 */
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;


      @GetMapping("/get")
      public String first(){

          return clientService.first();

      }
}
