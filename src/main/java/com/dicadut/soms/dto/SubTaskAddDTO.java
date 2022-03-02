package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-02 18:31
 */
@Data
public class SubTaskAddDTO {
    @ApiModelProperty(value = "巡检路线")
    private String inspectionRoute;
    @ApiModelProperty(value = "巡检范围起始桩号")
    private String inspectionStart;
    @ApiModelProperty(value = "巡检范围终止桩号")
    private String inspectionEnd;
    @ApiModelProperty(value = "打卡位置字符串")
    private String scanPosition;
    @ApiModelProperty(value = "任务包含的构件编号")
    private List<ComponentNumberDTO> componentNumberDTOS = new ArrayList<>();
}
