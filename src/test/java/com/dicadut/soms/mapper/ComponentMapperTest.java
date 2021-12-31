package com.dicadut.soms.mapper;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-12-31 14:35:37
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ComponentMapperTest {

    @Resource
    private ComponentMapper componentMapper;

    @Test
    public void selectCount() {
        System.out.println(componentMapper.selectCount());
    }
}
