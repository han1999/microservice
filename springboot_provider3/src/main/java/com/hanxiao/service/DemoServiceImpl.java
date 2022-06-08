package com.hanxiao.service;

import com.hanxiao.api.DemoService;
import com.hanxiao.api.Person;
import org.apache.dubbo.config.annotation.Service;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/5
 **/
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return name + ", 你好呀！3";
    }

    @Override
    public String sayHello(Person person) {
        return sayHello(person.getName());
//        return person.getName() + "你好！3";

    }
}
