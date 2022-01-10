package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel("APP待确认页面")
@Data
public class TaskAppListDTO {
        @ApiModelProperty("任务编码")
        private String code;
        @ApiModelProperty("桥梁上下层")
        private String bridgeStorey;
        @ApiModelProperty("起始桩号")
        private String stakeBegin;
        @ApiModelProperty("终止桩号")
        private String stakeEnd;
        @ApiModelProperty("任务详情")
        private String taskDetail;
        @ApiModelProperty("截止时间")
        private String deadTime;
        @ApiModelProperty("构件名称")
        private String componentName;
}
