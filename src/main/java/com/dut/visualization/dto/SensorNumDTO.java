package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:24 下午 2023/4/11
 * @ Description：传感器数量扇形图
 * @Version: $
 */
@Data
public class SensorNumDTO {
    @ApiModelProperty(value = "传感器类型")
    private String sensorType;

    @ApiModelProperty(value = "传感器数量")
    private String sensorNum;
}
