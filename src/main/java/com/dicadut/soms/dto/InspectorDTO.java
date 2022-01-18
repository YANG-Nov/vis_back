package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("分配任务多表查询")
@Data
public class InspectorDTO {
    @ApiModelProperty("巡检员id")
    private String id;
    @ApiModelProperty("巡检员姓名")
    private String name;
    @ApiModelProperty("当前任务编号")
    private String taskId;
    @ApiModelProperty("任务起始时间")
    private String startTime;
    @ApiModelProperty("任务截止时间")
    private String endTime;
    @ApiModelProperty("任务状态")
    private Integer taskStatus;
    @ApiModelProperty("巡检内容")
    private String inspectingContent;
}
