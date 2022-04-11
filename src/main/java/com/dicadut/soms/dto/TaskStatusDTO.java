package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 9:04 下午 2022/4/9
 * @ Description：任务状态查询
 * @Version: 1.0.0$
 */
@Data
public class TaskStatusDTO {
    @ApiModelProperty("任务状态")
    private String taskStatus;
}