package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:53 下午 2022/5/19
 * @ Description：构件信息
 * @Version: $
 */
@Data
public class SpecificComponentInformationDTO {
    @ApiModelProperty(value = "构件名称")
    private String componentName;

    @ApiModelProperty(value = "建成时间")
    private String time;

    @ApiModelProperty(value = "施工单位")
    private String constructionUnit;
}
