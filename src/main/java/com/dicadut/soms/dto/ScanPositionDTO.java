package com.dicadut.soms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description 某个打卡位置
 * @date 2022-03-01 20:35
 */
@Data
public class ScanPositionDTO {
    @JsonProperty("label")
    private String codeName;
    @JsonProperty("value")
    private String code;
}
