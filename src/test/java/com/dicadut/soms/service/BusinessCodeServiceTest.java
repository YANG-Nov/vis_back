package com.dicadut.soms.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2022-01-16 17:37:38
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessCodeServiceTest {

    @Resource
    private BusinessCodeService businessCodeService;

    @Test
    public void generateBusinessCode() {
        businessCodeService.generateBusinessCode("t_task");
    }
}
