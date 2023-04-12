package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 1:41 下午 2023/4/11
 * @ Description：传感器状态扇形图
 * @Version: $
 */
@Data
public class SensorStatusDTO {

    @ApiModelProperty(value = "是否在线：0在线，1离线")
    private String name;

    @ApiModelProperty(value = "数量")
    private String value;

}
