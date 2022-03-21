package com.dicadut.soms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApiModel("分配任务多表查询")
@Data
public class InspectorTaskDTO {
    @ApiModelProperty("巡检员id")
    private String id;
    @ApiModelProperty("巡检员姓名")
    @JsonProperty("name")
    private String realName;
    @ApiModelProperty("数量")
    private Integer amount;
    @ApiModelProperty(value = "任务")
    private String taskId;
    @ApiModelProperty(value = "任务状态: type=1002")

    private String taskStatus;

    private String taskType;

    @ApiModelProperty(value = "任务开始时间，精确到时")
    private LocalDate startTime;
    @ApiModelProperty(value = "任务截止时间，精确到时")
    private LocalDate endTime;
    @ApiModelProperty(value = "任务截止时间，精确到时")
    private LocalDateTime receiveTime;
    @ApiModelProperty(value = "任务截止时间，精确到时")
    private LocalDateTime finishTime;
    @ApiModelProperty(value = "巡检部位")
    private String inspectionPosition;
    @ApiModelProperty(value = "巡检部位")
    private String createBy;

    List<TaskSetDTO> children = new ArrayList<>();


    @ApiModelProperty(value = "index")
    private Integer key;

}
