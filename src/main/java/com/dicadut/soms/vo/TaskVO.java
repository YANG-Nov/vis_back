package com.dicadut.soms.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 14:12
 */
@ApiModel("接受提交任务")
@Data
public class TaskVO {
    @ApiModelProperty(value = "任务类型: 1001000001 日常巡检, 1001000002 定期检查,1001000003 特殊检查 1001000004 养护维修  ")
    @JsonProperty("jobType")
    private String taskType;
    @ApiModelProperty(value = "task的id")
    @JsonProperty("taskId")
    private String id;
    @ApiModelProperty(value = "巡检人员id")
    private String inspector;
    @ApiModelProperty(value = "任务类型: 1001000001 日常巡检, 1001000002 定期检查,1001000003 特殊检查 1001000004 养护维修  ")
    @JsonProperty("jobFreq")
    private String inspectionFrequency;
    @ApiModelProperty(value = "开始时间", example = "2021-09-30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startTime;
    @ApiModelProperty(value = "结束时间", example = "2021-09-30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endTime;
    @ApiModelProperty(value = "接收期限", example = "2021-09-30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime remindTime;
    @ApiModelProperty(value = "召回期限", example = "2021-09-30")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime recallTime;
    @ApiModelProperty(value = "养护工程师id，需要前端绑定账户")
    private String createBy;
    @ApiModelProperty(value = "子任务列表")
    private List<SubTaskVO> subTasks= new ArrayList<>();

}

