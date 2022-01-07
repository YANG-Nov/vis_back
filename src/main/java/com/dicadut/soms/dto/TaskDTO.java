package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 16:40
 */
@ApiModel("巡检任务状态扇形图")
@Data
public class TaskDTO {
    @ApiModelProperty("待领取任务数")
    private Integer wait4ReceivedCount;
    @ApiModelProperty("待审核任务数")
    private Integer wait4ReviewedCount;
    @ApiModelProperty("待重传任务数")
    private Integer wait4RetransmittedCount;
    @ApiModelProperty("巡检中任务数")
    private Integer inspectingCount;
}
