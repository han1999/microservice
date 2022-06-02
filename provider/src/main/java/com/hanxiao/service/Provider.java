package com.hanxiao.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/2
 **/

public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        System.in.read();
    }


}
