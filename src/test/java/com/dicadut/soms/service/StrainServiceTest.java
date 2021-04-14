package com.dicadut.soms.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-14 15:55:08
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StrainServiceTest {

    @Resource
    private StrainService strainService;

    @Test
    public void test() {
        strainService.list10();
    }
}
