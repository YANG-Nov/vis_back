package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fan_jennifer
 * @date 2021-11-2021/11/21 16:59
 */
@Data
public class DiseaseAppListDTO {
    @ApiModelProperty("病害名称")
    private String name;
    @ApiModelProperty("病害id")
    private String diseaseId;
}
