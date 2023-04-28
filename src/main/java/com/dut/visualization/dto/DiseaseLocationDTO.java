package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 10:57 上午 2023/4/27
 * @ Description：病害位置，用于创建模型
 * @Version: 1.0.0$
 */
@Data
public class DiseaseLocationDTO {
    @ApiModelProperty(value = "x")
    private double x;

    @ApiModelProperty(value = "y")
    private double y;

    @ApiModelProperty(value = "z")
    private double z;

    @ApiModelProperty(value = "病害程度 0轻微 1一般 2严重")
    private int degree;

    @ApiModelProperty(value = "模型编码")
    private String modelCode;

    @ApiModelProperty(value = "病害编码")
    private String diseaseCode;
}
