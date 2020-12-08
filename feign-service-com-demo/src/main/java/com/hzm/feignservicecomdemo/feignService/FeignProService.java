package com.hzm.feignservicecomdemo.feignService;

import com.hzm.feignservicecomdemo.feignService.impl.FeignProServiceImpl;
import com.hzm.feignservicecomdemo.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author
 * @createTime 2020/12/7 18:34
 */
/**
 * 注解属性 fallback - 当前接口远程调用服务发生问题时，使用哪一个对象中的对应方
 法用于实现容错逻辑。
 * Openfeign 技术中，容错处理是使用当前接口的实现类实现的。
 * 实现类中的方法实现，就是对应的容错 fallback 处理逻辑。
 */
@FeignClient(value = "feign-service-pro",fallback = FeignProServiceImpl.class) //fallbackFactory = 服务降级使用
public interface FeignProService {
    /**
     * 测试 GET 请求的方法。
     * 请求不传递任何的参数。
     */
    @RequestMapping(value = "/service/test", method = RequestMethod.GET)
    public List<String> testFeign();

    /**
     * 测试 GET 请求传递一个普通的参数。 /get?id=xxx&name=yyy
     * 在为 Feign 定义服务标准接口的时候，处理请求参数的方法参数，必须使用
     *
     * @RequestParam 注解描述。
     * 且，无论方法参数名和请求参数名是否一致，都需要定义@RequestParam 注解的
     * value/name 属性。
     */
    @GetMapping(value = "/service/get")
    public User getMultiParams(@RequestParam(value = "id") Integer id,
                               @RequestParam("name") String name);

    /**
     * 测试使用 POST 请求传递普通参数
     * 如果使用 POST 方式发起请求，传递多个普通参数，是使用请求头传递的参数。可
     * 以使用@RequestParam 注解来处理请求参数。
     */
    @PostMapping(value = "/service/post")
    public User postMultiParams(@RequestParam(value = "id") Integer id,
                                @RequestParam("name") String name);

    /**
     * 使用 POST 请求传递自定义类参数。
     * 必须使用@RequestBody 处理。
     */
    @PostMapping(value = "/service/postObjectParam")
    public User postObjectParam(@RequestBody User pojo);

}
