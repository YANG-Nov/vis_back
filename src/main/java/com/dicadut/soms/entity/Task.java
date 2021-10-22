package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 14:12
 */
@Data
@TableName("system.task")
public class Task {
    @ApiModelProperty(value = "任务id")
    private String id;
    @ApiModelProperty(value = "任务类型")
    private String taskType;
    @ApiModelProperty(value = "任务状态")
    private String taskStatus;
    @ApiModelProperty(value = "创建人id")//看看课程chapter这块corseid是怎么做的，需要同一吗
    private String creatorId;
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @ApiModelProperty(value = "开始时间", example = "2021-09-30 13:00:00")
    private Date beginTime;
    @ApiModelProperty(value = "结束时间", example = "2021-09-30 14:00:00")
    private Date endTime;
    @ApiModelProperty(value = "是否是临时任务", example = "1", allowableValues = "0,1")
    private Integer isMaintainer = 0;
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Integer isDeleted;

}
