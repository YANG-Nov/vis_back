package com.dicadut.soms.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-12-31 16:04:43
 */
@ApiModel("任务统计")
@Data
public class TaskStatisticDTO {
    @ApiModelProperty("总取任务数")
    private Integer totalCount;
    @ApiModelProperty("待领取任务数")
    private Integer wait4ReceivedCount;
    @ApiModelProperty("待审核任务数")
    private Integer wait4ReviewedCount;
    @ApiModelProperty("待重传任务数")
    private Integer wait4RetransmittedCount;
    @ApiModelProperty("巡检中任务数")
    private Integer inspectingCount;
}
