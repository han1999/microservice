package com.hanxiao.tk_mybatis;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/8
 **/
@Data
@Table(name = "user")
public class User {
    @Id
    private Integer id;

    private String name;

    private Integer age;
}
