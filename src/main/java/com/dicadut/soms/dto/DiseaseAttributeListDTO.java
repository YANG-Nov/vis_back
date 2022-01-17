package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DiseaseAttributeListDTO {
    @ApiModelProperty("病害特性")
    private String diseaseAttribute;
    @ApiModelProperty("病害特性值")
    private String diseaseAttributeValue;
}
