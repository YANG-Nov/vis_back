package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 10:22 上午 2022/5/5
 * @ Description：隧道基本信息
 * @Version: 1$
 */
@Data
public class TunnelBasicInformationDTO {
    @ApiModelProperty(value = "隧道名称")
    private String name;

    @ApiModelProperty(value = "业主单位")
    private String ownerUnit;

    @ApiModelProperty(value = "设计单位")
    private String designUnit;

    @ApiModelProperty(value = "施工单位")
    private String constructionUnit;

    @ApiModelProperty(value = "监理单位")
    private String supervisionUnit;

    @ApiModelProperty(value = "简介")
    private String introduction;

}
