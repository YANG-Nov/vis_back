package com.dicadut.soms.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-18 13:38
 */
@Data
public class TaskDiseaseDTO {

    @ApiModelProperty(value = "任务id: 格式 yyyyMMddxxxxxx，长度14位, 支持每日最多生成999999个任务")
    @TableId
    private String id;

    @ApiModelProperty(value = "任务类型: type=1001")
    private String taskType;

    @ApiModelProperty(value = "任务状态: type=1002")
    private String taskStatus;

    @ApiModelProperty(value = "任务开始时间，精确到时")
    private LocalDate startTime;

    @ApiModelProperty(value = "任务截止时间，精确到时")
    private LocalDate endTime;

    @ApiModelProperty(value = "接受期限，精确到时")
    private LocalDate remindTime;

    @ApiModelProperty(value = "召回期限，精确到时")
    private LocalDate recallTime;

    @ApiModelProperty(value = "巡检部位")
    private String inspectionPosition;
    @ApiModelProperty(value = "巡检部位")
    private String inspectionFrequency;
    @ApiModelProperty(value = "任务领取时间，精确到时")
    private LocalDateTime receiveTime;

    @ApiModelProperty(value = "任务完成时间，精确到时")
    private LocalDateTime finishTime;

    @ApiModelProperty(value = "巡检员id")
    private String inspectorId;

    @ApiModelProperty(value = "养护工程师id")
    private String createBy;

    @ApiModelProperty(value = "任务审核意见")
    private String reviewOpinion;
    @ApiModelProperty(value = "打卡位置")
    private String scanPositions;

    //diseaseRecord

    @ApiModelProperty(value = "任务编号")
    private String taskId;

    @ApiModelProperty(value = "构件id")
    private String componentId;

    @ApiModelProperty(value = "桥桩号id")
    private String bridgeId;

    @ApiModelProperty(value = "病害种类id")
    private String diseaseId;


    private Integer recordId;



    @ApiModelProperty(value = "病害记录种类：(1)输入框,(2)下拉框,(3)单选框,(4)照片/视频,(5)语音,(6)文本")
    private Integer type;

    @ApiModelProperty(value = "病害属性id")
    private String diseaseAttributeId;

    @ApiModelProperty(value = "病害记录内容")
    private String content;

    //diseaseAttribute
    private String group;
    private String value;
    private String uint;

    //component
    private String componentNumber;
    private String bridgePosition;

    //bridge
    private String location;



    //disease
    private String name;





}
