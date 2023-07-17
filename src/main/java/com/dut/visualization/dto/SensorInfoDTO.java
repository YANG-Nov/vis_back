package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 9:01 上午 2023/7/17
 * @ Description：传感器信息
 * @Version: 1.0.0$
 */
@Data
public class SensorInfoDTO {
    @ApiModelProperty(value = "传感器名称")
    private String name;
    @ApiModelProperty(value = "传感器编号")
    private String code;
    @ApiModelProperty(value = "厂家")
    private String manufactor;
    @ApiModelProperty(value = "安装单位")
    private String installUnit;
    @ApiModelProperty(value = "安装时间")
    private String installTime;
}
