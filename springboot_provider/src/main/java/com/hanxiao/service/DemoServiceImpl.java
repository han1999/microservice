package com.hanxiao.service;

import com.hanxiao.api.DemoService;
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
        return name + ", 你好呀！";
    }
}
