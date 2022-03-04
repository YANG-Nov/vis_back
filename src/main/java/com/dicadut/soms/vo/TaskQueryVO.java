package com.dicadut.soms.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-19 12:51
 */
@ApiModel("接受任务列表查询条件")
@Data
public class TaskQueryVO {
    private String taskType;
    private String taskStatus;
}
