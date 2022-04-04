package com.dicadut.soms.vo;

import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:59 下午 2022/4/4
 * @ Description：移动端任务详情展示
 * @Version: 1.0.0$
 */
public class TaskDetailAppVO {
    @ApiModelProperty("任务id")
    private String id;
    @ApiModelProperty("任务类型")
    private String taskType;
    @ApiModelProperty("接收时间")
    private String receiveTime;
    @ApiModelProperty("完成时间")
    private String finishTime;
    @ApiModelProperty("开始时间")
    private String startTime;
    @ApiModelProperty("结束时间")
    private String endTime;
    @ApiModelProperty("位置")
    private String position;
    @ApiModelProperty("巡检路线")
    private String inspectionRoute;
    @ApiModelProperty("打卡点位置")
    private String scanPositions;
    @ApiModelProperty("创建人")
    private String creatBy;
    @ApiModelProperty("构件")
    private String componentName;
    @ApiModelProperty("构件编号")
    private String componentNumber;
}
