package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 7:23 下午 2023/12/19
 * @ Description：查询有哪些管节
 * @Version: $
 */
@Data
public class SpecificTubeDTO {
    @ApiModelProperty(value = "构件id")
    private String componentId;
    @ApiModelProperty(value = "构件名称")
    private String componentName;
}
