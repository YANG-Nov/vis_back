package com.dicadut.soms.vo;

import com.dicadut.soms.dto.TaskComponentAppDTO;
import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:59 下午 2022/4/4
 * @ Description：移动端任务详情展示
 * @Version: 1.0.0$
 */
@Data
public class TaskDetailAppVO {
    @ApiModelProperty("任务id")
    private String id;
    @ApiModelProperty("任务类型")
    private String taskType;
    @ApiModelProperty("完成期限")
    private String recallTime;
    @ApiModelProperty("领取时间")
    private String remindTime;
    @ApiModelProperty("巡检时间")
    private String inspectionTime;
    @ApiModelProperty("巡检部位")
    private String inspectionPosition;
    @ApiModelProperty("巡检路线")
    private String inspectionRoute;
    @ApiModelProperty("打卡点位置")
    private String scanPositions;
    @ApiModelProperty("创建人")
    private String creatBy;
    @ApiModelProperty("导航栏")
    private List<TaskDetailAppVO.Item> position;

    @Data
    public static class Item{
        @ApiModelProperty("导航栏标题")
        private String inspectionLocation;
        private List<TaskDetailAppVO.Item.child> componentList;
        @Data
        public static class child{
            @ApiModelProperty("构件")
            private String componentName;
            @ApiModelProperty("构件编号")
            private String componentNumber;
        }
    }
}
