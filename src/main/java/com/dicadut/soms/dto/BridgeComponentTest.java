package com.dicadut.soms.dto;

import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description 修改bridgeComponent表
 * @date 2022-03-19 20:54
 */
@Data
public class BridgeComponentTest {
    private String bridgeId;
    private String componentId;
    private String parentId;
    private String name;
    private String stakeOrTrussNumber;
}
