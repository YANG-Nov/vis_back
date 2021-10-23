package com.dicadut.soms;

import com.dicadut.soms.mapper.UserMapper;
import com.dicadut.soms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SomsApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        System.out.println("#### test ####");
    }

    @Test
    void testMapper(){
        System.out.println(userMapper.selectById(1));
    }

    @Test
    void testService(){
        System.out.println(userService.getUserByUsername("123"));
    }
}
