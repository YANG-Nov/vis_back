package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:51 下午 2023/5/11
 * @ Description：主体结构病害发生时间统计
 * @Version: $
 */
@Data
public class DiseaseZtTimeDTO {
    @ApiModelProperty(value = "病害发生时间")
    private String createTime;

    @ApiModelProperty(value = "病害数量")
    private int value;
}
