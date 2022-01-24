package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 8:26 下午 2022/1/24
 * @ Description：App任务对应的打卡点
 * @Version: 1.0.0$
 */
@Data
public class TaskScanPositionAppListDTO {
    @ApiModelProperty("打卡点位置")
    private String name;
    @ApiModelProperty("打卡点位置id")
    private String id;
}
