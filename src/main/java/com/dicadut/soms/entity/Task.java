package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 14:12
 */
@Data
@TableName("system.task")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @ApiModelProperty(value = "任务id")
    @TableId
    private String id;
    @ApiModelProperty(value = "任务类型: 1001000001 日常巡检, 1001000002 定期检查,1001000003 特殊检查 1001000004 养护维修  ")
    private Integer taskType;
    @ApiModelProperty(value = "任务状态:1002000001 待领取 1002000002 进行中 1002000003 待审核 10020000004 待分配 10020000005 待重传 10020000006 巡检完成")
    private Integer taskStatus;
    @ApiModelProperty(value = "创建人id")
    private String creatorId;
    @ApiModelProperty(value = "检查人id")
    private String userId;
    @ApiModelProperty(value = "构件id")
    private String componentId;
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
    private Integer isTemporary = 0;
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Integer isDeleted;

}
