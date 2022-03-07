package com.dicadut.soms.dto;

import com.dicadut.soms.json.DeadLineSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:28 下午 2022/2/17
 * @ Description：APP任务列表中截止时间
 * @Version: 1.0.0$
 */
@ApiModel("APP任务列表页面，任务截止时间")
@Data
public class TaskEndTimeAppListDTO {
    @ApiModelProperty("任务编码")
    private String id;
    @ApiModelProperty("截止时间")
    private String endTime;
    @ApiModelProperty("剩余时间")
    @JsonSerialize(using = DeadLineSerializer.class)
    private String restTime;
}
