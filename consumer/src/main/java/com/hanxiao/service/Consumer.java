package com.hanxiao.service;

import com.hanxiao.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/2
 **/

public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.sayHello("zhangsan");
        System.out.println("hello = " + hello);
    }
}
