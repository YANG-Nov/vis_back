package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:29 下午 2022/1/24
 * @ Description：APP添加病害页面，选择构件位置
 * @Version: 1.0.0
 */
@Data
public class ComponentPositionAppListDTO {
    @ApiModelProperty("构件位置")
    private String position;
    @ApiModelProperty("构件位置id")
    private String positionId;
}
