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
public class ComponentInformationDTO {
    @ApiModelProperty(value = "构件名称")
    private String name;

    @ApiModelProperty(value = "材料")
    private String material;

    @ApiModelProperty(value = "材料")
    private String installTime;

    @ApiModelProperty(value = "材料")
    private String installDepartment;

    @ApiModelProperty(value = "相关细部图纸等")
    private String document;
}
