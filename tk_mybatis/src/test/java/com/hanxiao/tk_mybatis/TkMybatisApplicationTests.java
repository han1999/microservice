package com.hanxiao.tk_mybatis;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TkMybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(18);
        user.setName("zhangsan");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);

        user.setAge(null);
        user.setName("lisi");
        int insert1 = userMapper.insert(user);
        System.out.println("insert1 = " + insert1);

        user.setName("wangwu");
        int insert2 = userMapper.insertSelective(user);
        System.out.println("insert2 = " + insert2);
    }

//    @Test
//    void contextLoads() {
//    }

}
