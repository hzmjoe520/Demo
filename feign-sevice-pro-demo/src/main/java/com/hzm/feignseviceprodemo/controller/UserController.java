package com.hzm.feignseviceprodemo.controller;

import com.hzm.feignseviceprodemo.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @createTime 2020/12/7 18:23
 */

@RestController
@RequestMapping("/service")
public class UserController {


    @RequestMapping(value= "/test", method= RequestMethod. GET )
    public List<String> testFeign(){

        //模拟超时 引发降级
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return  Arrays. asList ("这是远程调用feign的相应");
    }
/**
 * 测试 GET 请求传递一个普通的参数。 /get?id=xxx&name=yyy
 * 在为 Feign 定义服务标准接口的时候，处理请求参数的方法参数，必须使用
 @RequestParam 注解描述。
  * 且，无论方法参数名和请求参数名是否一致，都需要定义@RequestParam 注解的
 value/name 属性。
 */
    @GetMapping(value= "/get")
    public User getMultiParams(@RequestParam(value =  "id") Integer id,
                               @RequestParam( "name") String name){

        System. out .println("getMultiParams method , run,  parameters is [ [  id : : " +
                id + " ;name: " + name + "  ]");
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }
/**
 * 测试使用 POST 请求传递普通参数
 * 如果使用 POST 方式发起请求，传递多个普通参数，是使用请求头传递的参数。可
 以使用@RequestParam 注解来处理请求参数。
 */
    @PostMapping(value= "/post")
    public User postMultiParams(@RequestParam(value =  "id") Integer id,
                                  @RequestParam( "name") String name){

        //模拟超时 引发降级
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System. out .println("PostMultiParams method , run,  parameters is [ [  id : : " +
                id + " ;name: " + name + "  ]");
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;

    }
    /**
     * 使用 POST 请求传递自定义类参数。
     * 必须使用@RequestBody 处理。
     */
    @PostMapping(value= "/postObjectParam")
    public User postObjectParam(@RequestBody User pojo){

        //模拟超时 引发降级
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System. out .println("postObjectParam d method , run, s parameters s is [ [ "+ pojo
                + " ]");
        return pojo;

    }

}
