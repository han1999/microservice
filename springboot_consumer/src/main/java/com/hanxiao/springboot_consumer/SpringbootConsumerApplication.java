package com.hanxiao.springboot_consumer;

import com.hanxiao.api.Person;
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

        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        for (int i = 0; i < 90; i++) {
            String result = thirdService.sayHello("韩枭");
            if (result.endsWith("1")) {
                firstCount++;
                System.out.println("调用provider1");
            } else if (result.endsWith("2")) {
                secondCount++;
                System.out.println("调用provider2");
            }else {
                thirdCount++;
                System.out.println("调用provider3");
            }
        }
        System.out.println("firstCount = " + firstCount);
        System.out.println("secondCount = " + secondCount);
        System.out.println("thirdCount = " + thirdCount);

        Person person = new Person();
        person.setName("zhangsan");
        for (int i = 0; i <10 ; i++) {

            thirdService.sayHello(person);
            String sayHello1 = thirdService.sayHello(person);
            System.out.println("sayHello1 = " + sayHello1);
        }
    }


}
