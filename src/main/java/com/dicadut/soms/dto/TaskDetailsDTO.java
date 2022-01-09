package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel("任务统计")
@Data
public class TaskDetailsDTO {
    @ApiModelProperty("任务概述")
    private String taskSummary;
    @ApiModelProperty("匝道")
    private String ramp;
    @ApiModelProperty("起始桩号")
    private String stakeBegin;
    @ApiModelProperty("终止桩号")
    private String stakeEnd;
    @ApiModelProperty("构件名称")
    private String componentName;
}

