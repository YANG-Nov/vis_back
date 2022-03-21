package com.dicadut.soms.dto;

import com.dicadut.soms.Annotation.EnumMapper;
import com.dicadut.soms.enumeration.AllEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-19 12:56
 */
@ApiModel("数据库中查到返给前端列表")
@Data
public class TaskSetDTO {
    @ApiModelProperty(value = "任务")
    private String taskId;


    @EnumMapper(AllEnum.class)
    @ApiModelProperty(value = "任务类型: type=1001")
    private String taskType;//jobType Jane_TODO 2022/3/17
    @EnumMapper(AllEnum.class)
    @ApiModelProperty(value = "任务状态: type=1002")
    private String taskStatus;//jobStatus Jane_TODO 2022/3/17

    @ApiModelProperty(value = "任务开始时间，精确到时")
    private LocalDate startTime;

    @ApiModelProperty(value = "任务截止时间，精确到时")
    private LocalDate endTime;

    @ApiModelProperty(value = "巡检员姓名")
    @JsonProperty("inspectorName")
    private String realName;//Jane_TODO 2022/3/17
    @EnumMapper(AllEnum.class)
    @ApiModelProperty(value = "制定任务姓名")
    private String createBy;

    @ApiModelProperty(value = "巡检部位")
    private String inspectionPosition;



}
