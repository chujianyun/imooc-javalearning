package com.imooc.basic.converter;

import com.imooc.basic.converter.entity.UserDO;
import com.imooc.basic.converter.entity.UserDTO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDO2DTOConverterTest {

    private Set<UserDO> userDOs;

    private BeanCopier beanCopier = BeanCopier.create(UserDO.class, UserDTO.class, false);

    private Mapper mapper = new DozerBeanMapper();

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @BeforeAll
    public void init() {
        EasyRandom easyRandom = new EasyRandom();
        userDOs = easyRandom
                .objects(UserDO.class, 100000)
                .collect(Collectors.toSet());
    }

    @Test
    public void getSetTest() {
        for (UserDO userDO : userDOs) {
            UserDTO userDTO = UserConverter.convertToDTO(userDO);
            checkEquals(userDO, userDTO);
        }
    }

    @Test
    public void springCopyTest() throws InvocationTargetException, IllegalAccessException {
        for (UserDO userDO : userDOs) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userDTO, userDO);
            checkEquals(userDO, userDTO);
        }
    }


    @Test
    public void springCopyTest2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        for (UserDO userDO : userDOs) {
            UserDTO userDTO = new UserDTO();
            PropertyUtils.copyProperties(userDTO, userDO);
            checkEquals(userDO, userDTO);
        }
    }

    @Test
    public void commonsCopyTest() throws InvocationTargetException, IllegalAccessException {
        for (UserDO userDO : userDOs) {
            UserDTO userDTO = new UserDTO();
            org.apache.commons.beanutils.BeanUtils.copyProperties(userDTO, userDO);
            checkEquals(userDO, userDTO);
        }
    }

    @Test
    public void cglibTest() {
        for (UserDO userDO : userDOs) {
            UserDTO userDTO = new UserDTO();
            beanCopier.copy(userDO, userDTO, null);
            checkEquals(userDO, userDTO);
        }
    }

    @Test
    public void dozerTest() {
        for (UserDO userDO : userDOs) {
            UserDTO userDTO = mapper.map(userDO, UserDTO.class);
            checkEquals(userDO, userDTO);
        }
    }

    @Test
    public void orikaTest() {
        for (UserDO userDO : userDOs) {
            MapperFacade mapper = mapperFactory.getMapperFacade();
            UserDTO userDTO = new UserDTO();
            mapper.map(userDO, userDTO);
            checkEquals(userDO, userDTO);
        }

    }


    private void checkEquals(UserDO userDO, UserDTO userDTO) {
        assertEquals(userDO.getName(), userDTO.getName());
        assertEquals(userDO.getAge(), userDTO.getAge());
        assertEquals(userDO.getNickName(), userDTO.getNickName());
    }

}
