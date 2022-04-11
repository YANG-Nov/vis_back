package com.dicadut.soms.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description 接受添加任务页面传过来的子任务
 * @date 2022-03-02 17:16
 */
@Data
@ApiModel("接受前端传过来的子任务")
public class SubTaskVO {
    @ApiModelProperty(value = "巡检路线")
    private String inspectionRoute;
    @ApiModelProperty(value = "巡检范围起始桩号")
    private String inspectionStart;
    @ApiModelProperty(value = "巡检范围终止桩号")
    private String inspectionEnd;

    @ApiModelProperty(value = "打卡位置数组")
    private String[] scanPositions;
    @ApiModelProperty(value = "打卡位置字符串")
    private String scanPosition;

    @ApiModelProperty(value = "构件id数组")
    private String[] selectedComponents;


}
