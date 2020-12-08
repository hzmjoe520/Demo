package com.hzm.feignservicecomdemo.controller;

import com.hzm.feignservicecomdemo.feignService.FeignProService;
import com.hzm.feignservicecomdemo.pojo.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @createTime 2020/12/7 18:38
 */
@RestController
@RequestMapping("/client")
public class UserComController {

      @Autowired
      private FeignProService firstClientService;


    @GetMapping(value= "/test")
    public List<String> testFeign() {
        return  this.firstClientService.testFeign();
    }
    @GetMapping(value= "/get")
    public User getMultiParams(@RequestParam("id") Integer id, @RequestParam("name") String name) {
         return  this.firstClientService.getMultiParams(id, name);
    }
    @GetMapping(value= "/post")
    public User postMultiParams(@RequestParam("id") Integer id, @RequestParam("name") String name) {
       return  this.firstClientService.postMultiParams(id, name);
    }

    @PostMapping(value= "/postObjectParam")
    public User postObjectParam(User pojo) {
        return  this.firstClientService.postObjectParam(pojo);
    }
}


