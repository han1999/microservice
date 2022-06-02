package com.hanxiao.service;

import com.hanxiao.api.DemoService;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/2
 **/

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return name + ", 你好！";
    }
}
