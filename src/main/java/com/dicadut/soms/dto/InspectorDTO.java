package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel("分配任务多表查询")
@Data
public class InspectorDTO {
    @ApiModelProperty("巡检员id")
    private String id;
    @ApiModelProperty("巡检员姓名")
    private String name;
    @ApiModelProperty(value = "任务")
    private String taskId;
    @ApiModelProperty(value = "任务状态: type=1002")
    private String taskStatus;
    @ApiModelProperty(value = "任务开始时间，精确到时")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "任务截止时间，精确到时")
    private LocalDateTime endTime;
    @ApiModelProperty(value = "巡检部位")
    private String inspectionPosition;

    @ApiModelProperty(value = "index")
    private Integer key;

}
