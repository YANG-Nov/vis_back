package com.dicadut.soms.mapper;


import com.dicadut.soms.domain.Bridge;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2022-01-26 14:50:05
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BridgeMapperTest {
    @Resource
    private BridgeMapper bridgeMapper;

    @Test
    public void insert() {
        Bridge bridge = new Bridge();
        bridge.setId("9999");
        bridge.setBridgeName("测试");
        bridgeMapper.insert(bridge);
    }

    @Test
    public void delete() {
        bridgeMapper.deleteById("9999");
    }

    @Test
    public void select() {
        bridgeMapper.selectById("9999");
    }

    @Test
    public void update() {
        Bridge bridge = bridgeMapper.selectById("9999");
        bridge.setLine("B");
        bridge.setStakeOrTrussNumber("1");
        bridge.setMainOrApproach("1");
        bridge.setLocation("loc");
        bridgeMapper.updateById(bridge);
    }
}
