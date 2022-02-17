package com.dicadut.soms.dto;

import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
        @ApiModelProperty("巡检桩号最小值")
        @JsonSerialize(using = StakeNumberSerializer.class)
        @JsonDeserialize(using = StakeNumberDeserializer.class)
        private String inspectionStakeNumberMin;
        @ApiModelProperty("巡检桩号最大值")
        @JsonSerialize(using = StakeNumberSerializer.class)
        @JsonDeserialize(using = StakeNumberDeserializer.class)
        private String inspectionStakeNumberMax;
        @ApiModelProperty("构件所属匝道")
        private String route;
        @ApiModelProperty("构件所在桩号最小值")
        @JsonSerialize(using = StakeNumberSerializer.class)
        @JsonDeserialize(using = StakeNumberDeserializer.class)
        private String stakeOrTrussNumberMin;
        @ApiModelProperty("构件所在桩号最大值")
        @JsonSerialize(using = StakeNumberSerializer.class)
        @JsonDeserialize(using = StakeNumberDeserializer.class)
        private String stakeOrTrussNumberMax;
        @ApiModelProperty("二级构件名称")
        private String levelTwoParentName;
        @ApiModelProperty("截止时间")
        private String endTime;
}
