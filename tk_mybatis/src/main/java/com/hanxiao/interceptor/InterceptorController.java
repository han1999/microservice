package com.hanxiao.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/8
 **/
@RestController
public class InterceptorController {

    @GetMapping("/test")
    public String test() {
        return "test ok";
    }
}
