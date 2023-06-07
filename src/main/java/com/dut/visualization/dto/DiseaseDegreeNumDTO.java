package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:37 下午 2023/6/6
 * @ Description：
 * @Version: $
 */
@Data
public class DiseaseDegreeNumDTO {
    @ApiModelProperty(value = "病害严重程度")
    private String name;
    @ApiModelProperty(value = "病害数量")
    private String value;
}
