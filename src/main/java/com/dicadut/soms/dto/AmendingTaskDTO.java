package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-19 12:56
 */
@Data
public class AmendingTaskDTO {
    @ApiModelProperty(value = "任务")
    private String taskId;

    @ApiModelProperty(value = "任务类型: type=1001")
    private String taskType;

    @ApiModelProperty(value = "任务状态: type=1002")
    private String taskStatus;

    @ApiModelProperty(value = "任务开始时间，精确到时")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "任务截止时间，精确到时")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "巡检员姓名")
    private String inspectorName;

    @ApiModelProperty(value = "制定任务姓名")
    private String createBy;

    @ApiModelProperty(value = "巡检部位")
    private String inspectionPosition;



}
