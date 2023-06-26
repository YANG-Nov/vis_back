package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 9:26 上午 2023/6/15
 * @ Description：病害发生时间-数量统计
 * @Version: $
 */
@Data
public class DiseaseTimeNumDTO {
    @ApiModelProperty(value = "时间")
    private String name;
    @ApiModelProperty(value = "数量")
    private Integer value;
}
