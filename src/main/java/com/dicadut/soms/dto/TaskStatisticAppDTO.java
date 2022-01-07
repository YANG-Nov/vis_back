package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("App首页任务统计")
@Data
public class TaskStatisticAppDTO {
    @ApiModelProperty("总取任务数")
    private Integer totalCount;
    @ApiModelProperty("已完成任务数")
    private Integer finishCount;
    @ApiModelProperty("已完成任务数占总数百分比")
    private String finishPercentage;
}
