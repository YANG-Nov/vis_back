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
 * @date 2021-12-31 16:50:18
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BridgeServiceTest {

    @Resource
    private BridgeService bridgeService;

    @Test
    public void getComponentNumberList() {

        log.info("#### 启动单元测试 saveTaskMenu");
        log.info("{}", bridgeService.getComponentNumberList("12000","12016","2001000012"));
        log.info("#### 结束单元测试 saveTaskMenu()");
    }
    @Test
    public void getLocationList() {

        log.info("#### 启动单元测试 saveTaskMenu");
        log.info("{}", bridgeService.getLocationList());
        log.info("#### 结束单元测试 saveTaskMenu()");
    }

}
