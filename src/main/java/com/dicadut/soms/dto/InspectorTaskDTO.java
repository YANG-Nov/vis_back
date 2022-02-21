package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-20 0:12
 */
@Data
@Deprecated
public class InspectorTaskDTO {
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
}
