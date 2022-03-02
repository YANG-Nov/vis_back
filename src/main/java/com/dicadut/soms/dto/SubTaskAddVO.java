package com.dicadut.soms.dto;

import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-02 17:16
 */
@Data
public class SubTaskAddVO {
    @ApiModelProperty(value = "巡检路线")
    private String inspectionRoute;
    @ApiModelProperty(value = "巡检范围起始桩号")
    private String inspectionStart;
    @ApiModelProperty(value = "巡检范围终止桩号")
    private String inspectionEnd;
    @ApiModelProperty(value = "打卡位置集合")
    private  List<ScanPositionDTO> scanPositionDTOS = new ArrayList<>();
    @ApiModelProperty(value = "打卡位置字符串")
    private String scanPosition;
    private String componentNumberId;
    @JsonSerialize(using = StakeNumberSerializer.class)
    @JsonDeserialize(using = StakeNumberDeserializer.class)
    private String componentNumber;


}
