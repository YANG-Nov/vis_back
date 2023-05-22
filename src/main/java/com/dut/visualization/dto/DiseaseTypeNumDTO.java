package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:53 下午 2023/5/19
 * @ Description：病害类型-数量统计
 * @Version: $
 */
@Data
public class DiseaseTypeNumDTO {
    @ApiModelProperty(value = "病害类型")
    private String name;

    @ApiModelProperty(value = "病害数量")
    private String value;
}
