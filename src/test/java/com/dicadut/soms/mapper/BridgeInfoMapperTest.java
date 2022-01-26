package com.dicadut.soms.mapper;


import com.dicadut.soms.domain.BridgeInfo;
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
public class BridgeInfoMapperTest {
    @Resource
    private BridgeInfoMapper bridgeInfoMapper;

    @Test
    public void insert() {
        BridgeInfo bridgeInfo = new BridgeInfo();
        bridgeInfo.setId("9999");
        bridgeInfo.setBridgeName("测试");
        bridgeInfoMapper.insert(bridgeInfo);
    }

    @Test
    public void delete() {
        bridgeInfoMapper.deleteById("9999");
    }

    @Test
    public void select() {
        bridgeInfoMapper.selectById("9999");
    }

    @Test
    public void update() {
        BridgeInfo bridgeInfo = bridgeInfoMapper.selectById("9999");
        bridgeInfo.setLine("B");
        bridgeInfo.setStakeOrTrussNumber("1");
        bridgeInfo.setMainOrApproach("1");
        bridgeInfo.setLocation("loc");
        bridgeInfoMapper.updateById(bridgeInfo);
    }
}
