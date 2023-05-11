package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:21 下午 2023/5/11
 * @ Description：主体结构病害发生时间统计 数据库拿到的格式
 * @Version: 1.0.0$
 */
@Data
public class DiseaseZtTimeDTO1 {
    @ApiModelProperty(value = "病害发生时间")
    private String createTime;

    @ApiModelProperty(value = "病害编码")
    private String diseaseCode;

    @ApiModelProperty(value = "是否修复")
    private int isRepair;

}
