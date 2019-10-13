package com.imooc.basic.converter;

import java.time.Instant;
import java.util.Date;

import com.imooc.basic.converter.entity.UserDO;
import com.imooc.basic.converter.entity.UserDTO;

public class UserConverter {


    public static UserDTO convertToDTO(UserDO source) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(source.getName());
        userDTO.setAge(source.getAge());
        userDTO.setNickName(source.getNickName());
        userDTO.setBirthDay(source.getBirthDay());
        return userDTO;
    }

    public static UserDO convertToDO(UserDO source) {
        UserDO userDO = new UserDO();
        userDO.setId(source.getId());
        userDO.setName(source.getName());
        userDO.setAge(source.getAge());
        userDO.setNickName(source.getNickName());
        userDO.setBirthDay(source.getBirthDay());
        return userDO;
    }

    // 转换成VO等等

    private UserDO mockUserDO() {
        UserDO userDO = new UserDO();
        userDO.setId(0L);
        userDO.setName("测试");
        userDO.setAge(0);
        userDO.setNickName("test");
        userDO.setBirthDay(Date.from(Instant.now()));
        return userDO;
    }
}
