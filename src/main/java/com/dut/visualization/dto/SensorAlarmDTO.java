package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:55 下午 2023/4/11
 * @ Description：
 * @Version: $
 */
@Data
public class SensorAlarmDTO {
    @ApiModelProperty(value = "传感器报警类型")
    private String name;

    @ApiModelProperty(value = "传感器不同报警类型的数量")
    private String value;
}
