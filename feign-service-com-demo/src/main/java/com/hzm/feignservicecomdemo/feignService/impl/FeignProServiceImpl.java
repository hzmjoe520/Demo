package com.hzm.feignservicecomdemo.feignService.impl;

import com.hzm.feignservicecomdemo.feignService.FeignProService;
import com.hzm.feignservicecomdemo.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @createTime 2020/12/7 20:01
 */
@Component
public class FeignProServiceImpl implements FeignProService {
    @Override
    public List<String> testFeign() {

        return Arrays. asList ("Openfeign  返回托底数据");
    }

    @Override
    public User getMultiParams(Integer id, String name) {
        User user = new User();
        user.setId(0);
        user.setUsername("托底数据");
        user.setRemark( "getMultiParams");
        return user;
    }

    @Override
    public User postMultiParams(Integer id, String name) {
        User user = new User();
        user.setId(0);
        user.setUsername("托底数据");
        user.setRemark( "postMultiParams");
         return user;
    }

    @Override
    public User postObjectParam(User pojo) {
        User user = new User();
        user.setId(0);
        user.setUsername("托底数据");
        user.setRemark( "postObjectParam");
        return user;
    }
}
