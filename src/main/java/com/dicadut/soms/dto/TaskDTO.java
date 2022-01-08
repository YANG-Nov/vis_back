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
    private int name;
    private int value;
}
