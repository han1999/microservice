package com.hanxiao.springboot_consumer;

import com.hanxiao.api.DemoService;
import com.hanxiao.api.Person;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/5
 **/
@Component
public class ThirdService {

//    @Reference(interfaceClass = DemoService.class, loadbalance = "roundrobin")
//    @Reference(interfaceClass = DemoService.class, loadbalance = "leastactive")
//    @Reference(interfaceClass = DemoService.class, loadbalance = "consistenthash")
    @Reference
    DemoService demoService;

    public String sayHello(String name) {
        return demoService.sayHello(name);
    }

    public String sayHello(Person person) {
        return demoService.sayHello(person);
    }
}
