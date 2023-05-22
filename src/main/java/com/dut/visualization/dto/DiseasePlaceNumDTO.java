package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 12:28 下午 2023/5/8
 * @ Description：病害信息页 病害部位-数量统计（主体、接头、附属）
 * @Version: $
 */
@Data
public class DiseasePlaceNumDTO {
    @ApiModelProperty(value = "病害部位")
    private String name;

    @ApiModelProperty(value = "病害数量")
    private String value;
}
