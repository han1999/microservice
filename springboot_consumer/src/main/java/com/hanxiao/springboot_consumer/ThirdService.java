package com.hanxiao.springboot_consumer;

import com.hanxiao.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/5
 **/
@Component
public class ThirdService {

    @Reference
    DemoService demoService;

    public String sayHello(String name) {
        return demoService.sayHello(name);
    }
}
