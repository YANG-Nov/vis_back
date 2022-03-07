package com.dicadut.soms.dto;

import com.dicadut.soms.json.DeadLineSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel("APP任务列表页面")
@Data
public class TaskAppListDTO {
        @ApiModelProperty("任务编码")
        private String id;
        @ApiModelProperty("巡检路线")
        private String inspectionRoute;
        @ApiModelProperty("构件所在位置")
        private String position;
        @ApiModelProperty("截止时间")
        private String endTime;
        @ApiModelProperty("剩余时间")
        @JsonSerialize(using = DeadLineSerializer.class)
        private String restTime;
}
