package com.hanxiao.springboot_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootConsumerApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context
                = SpringApplication.run(SpringbootConsumerApplication.class, args);
        ThirdService thirdService = context.getBean(ThirdService.class);
        String sayHello = thirdService.sayHello("zhangsan");
        System.out.println("sayHello = " + sayHello);
    }

}
