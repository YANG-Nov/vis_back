package com.dicadut.soms.vo;

import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description 前端传过来的起始桩号id，bridge表中的id
 * @date 2022-03-01 20:20
 */
@Data
public class InspectionScopeVO {
    private String start;
    private String end;
}
