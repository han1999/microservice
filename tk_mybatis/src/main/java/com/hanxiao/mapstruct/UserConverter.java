package com.hanxiao.mapstruct;

import com.hanxiao.tk_mybatis.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/6/8
 **/
//@Mapper will be replaced by @Component
@Mapper(componentModel = "spring")
public interface UserConverter {
    @Mappings(
            @Mapping(source = "name", target = "username")
    )
    UserDTO user2UserDTO(User user);

    List<UserDTO> users2UserDTOs(List<User> users);
}
