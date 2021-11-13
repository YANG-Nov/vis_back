package com.dicadut.soms.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserStatus {
    @ApiModelProperty(value = "职务", example = "0管理员1巡检员2维护员", allowableValues = "0,1,2")
    private Integer duty;
    @ApiModelProperty(value = "工作状态", example = "1", allowableValues = "0,1")
    private Integer status;
}
