package com.dicadut.soms.dto;

import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:34 下午 2022/2/17
 * @ Description：APP任务列表中任务详情
 * @Version: 1.0.0$
 */
@ApiModel("APP任务列表页面，任务详情")
@Data
public class TaskDetailsAppListDTO {
    @ApiModelProperty("任务编码")
    private String id;
    @ApiModelProperty("构件所在位置")
    private String position;
}
