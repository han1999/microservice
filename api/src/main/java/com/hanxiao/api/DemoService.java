package com.hanxiao.api;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/5
 **/

public interface DemoService {
    String sayHello(String name);

    String sayHello(Person person);
}
