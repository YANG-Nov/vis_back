package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DiseaseAttributeListDTO {
    @ApiModelProperty("病害特性名称")
    private String name;
    @ApiModelProperty("病害特性id")
    private String diseaseAttributeId;
    @ApiModelProperty("病害特性值")
    private String value;
    @ApiModelProperty("病害特性种类：1手动输入，2下拉框，3选择是否")
    private String type;
    @ApiModelProperty("病害特性值单位")
    private String unit;
}
