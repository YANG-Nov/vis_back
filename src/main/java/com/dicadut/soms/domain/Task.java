package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 14:12
 */
@Data
@TableName("t_task")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Task对象", description="任务表")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "打卡位置")
    private String scanPositions;

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

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删, 0未删, 1已删")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "移入记录表, 0未移入, 1已移入")
    private Integer isRecorded;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
