package com.hanxiao.tk_mybatis;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/8
 **/
@Data
@Table(name = "user")
public class User2 {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    @Column(name = "name")
    private String username;

    private Integer age;
}
