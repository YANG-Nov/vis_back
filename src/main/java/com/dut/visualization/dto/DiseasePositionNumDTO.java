package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:11 下午 2023/6/6
 * @ Description：病害发生位置-数量统计图
 * @Version: $
 */
@Data
public class DiseasePositionNumDTO {
    @ApiModelProperty(value = "构件名称")
    private String name;
    @ApiModelProperty(value = "数量")
    private String value;
}
