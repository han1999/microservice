package com.hanxiao.springboot_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringbootProviderApplication3 {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(SpringbootProviderApplication3.class, args);
        System.in.read();
    }

}
