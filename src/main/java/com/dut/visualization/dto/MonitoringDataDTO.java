package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:15 下午 2023/4/6
 * @ Description：
 * @Version: $
 */
@Data
public class MonitoringDataDTO {
    @ApiModelProperty(value = "传感器名称")
    private String componentName;

    @ApiModelProperty(value = "X轴坐标值")
    private String x;

    @ApiModelProperty(value = "Y轴坐标值")
    private String y;
}
