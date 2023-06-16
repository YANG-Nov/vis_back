package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 9:18 上午 2023/6/15
 * @ Description：通过code和repair筛选出的结果
 * @Version: $
 */
@Data
public class DiseaseSelectByCodeAndRepair {
    @ApiModelProperty(value = "构件编码")
    private String diseaseCode;
    @ApiModelProperty(value = "是否修复")
    private String isRepair;
    @ApiModelProperty(value = "开始时间和结束时间")
    private String triggerDate;
}
