package com.hanxiao.api;

import java.io.Serializable;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/6
 **/


public class Person implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
