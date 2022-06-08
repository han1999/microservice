package com.hanxiao.tk_mybatis;


import com.hanxiao.mapstruct.UserConverter;
import com.hanxiao.mapstruct.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TkMybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapper2 userMapper2;

    @Autowired
    UserConverter userConverter;

    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(18);
        user.setName("zhangsan");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);

        user.setAge(null);
        user.setId(null);
        user.setName("lisi");
        int insert1 = userMapper.insert(user);
        System.out.println("insert1 = " + insert1);

        user.setName("wangwu");
        user.setId(null);
        int insert2 = userMapper.insertSelective(user);
        System.out.println("insert2 = " + insert2);


    }

    @Test
    public void testInsertUseGeneratedKeys() {
        User user = new User();
        user.setName("zhaoliu");
        int insert3 = userMapper.insert(user);
        System.out.println("insert3 = " + insert3);
        System.out.println("user = " + user);
    }

//    @Test
//    void contextLoads() {
//    }

    @Test
    public void testQuery() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println("user = " + user);

        User user1 = new User();
        user1.setId(11);
        User user2 = userMapper.selectByPrimaryKey(user1);
        System.out.println("user2 = " + user2);

        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("name", "hanxiao")
                .andEqualTo("age", "-1");
        List<User> users = userMapper.selectByExample(example);
        System.out.println("users = " + users);


        Example example1 = new Example(User.class);
        example1.createCriteria()
                .andEqualTo("name", "hanxiao")
                .orEqualTo("age", "-1");
        List<User> users1 = userMapper.selectByExample(example1);
        System.out.println("users1 = " + users1);
    }

    @Test
    public void testUpdate() {
        User2 user2 = new User2();
        user2.setUsername("bifujian");
        Example example = new Example(user2.getClass());
        example.createCriteria().andEqualTo("username", "lisi");
        int i = userMapper2.updateByExample(user2, example);
        System.out.println("i = " + i);
    }

    @Test
    public void testDelete() {
        Example example = new Example(User2.class);
        example.createCriteria().andEqualTo("username", "bifujian");
        int i = userMapper2.deleteByExample(example);
        System.out.println("i = " + i);
    }


    @Test
    public void testMapStruct() {
        Example example = new Example(User.class);
        example.createCriteria().andGreaterThan("age", 17);
        List<User> users = userMapper.selectByExample(example);
        System.out.println("users = " + users);

        User user = users.get(0);
        System.out.println("user = " + user);
        UserDTO userDTO = userConverter.user2UserDTO(user);
        System.out.println("userDTO = " + userDTO);

        List<UserDTO> userDTOs = userConverter.users2UserDTOs(users);
        System.out.println("userDTOs = " + userDTOs);
    }

}
