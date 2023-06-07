package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 6:00 下午 2023/5/31
 * @ Description：
 * @Version: $
 */
@Data
public class SensorPositionDTO {
    @ApiModelProperty(value = "x")
    private double x;

    @ApiModelProperty(value = "y")
    private double y;

    @ApiModelProperty(value = "z")
    private double z;

    @ApiModelProperty(value = "传感器状态 在线0不在线1")
    private int online;

    @ApiModelProperty(value = "传感器报警 正常0一级预警1二级预警2")
    private int alarm;

    @ApiModelProperty(value = "测点")
    private String monitoringPoint;

    @ApiModelProperty(value = "模型编码")
    private String modelCode;
}
