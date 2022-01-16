package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ComponentAppListDTO {
    @ApiModelProperty("构件名称（类型）")
    private String componentName;
}
