package com.dicadut.soms.dto;

import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:43 下午 2022/4/4
 * @ Description：App端查看任务详情（数据库查出的结果）
 * @Version: 1.0.0$
 */
public class TaskDetailAppDTO {
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
    @ApiModelProperty("匝道")
    private String location;
    @ApiModelProperty("父构件名称")
    private String parentName;
    @ApiModelProperty("巡检路线")
    private String inspectionRoute;
    @ApiModelProperty("打卡点位置")
    private String scanPositions;
    @ApiModelProperty("创建人")
    private String creatBy;
    @ApiModelProperty("构件")
    private String componentName;
    @ApiModelProperty("构件桩号")
    @JsonSerialize(using = StakeNumberSerializer.class)
    @JsonDeserialize(using = StakeNumberDeserializer.class)
    private String stakeOrTrussNumber;
    @ApiModelProperty("构件顺序")
    private String orderNumber;
}
