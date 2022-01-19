package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@ApiModel("分配任务多表查询")
@Data
public class InspectorDTO {
    @ApiModelProperty("巡检员id")
    private String id;
    @ApiModelProperty("巡检员姓名")
    private String name;

    private List<InspectorTaskDTO> children = new ArrayList<>();
}
