package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 8:06 下午 2023/12/19
 * @ Description：相机位置 转换视角
 * @Version: $
 */
@Data
public class CameraPositionDTO {
    @ApiModelProperty(value = "相机x坐标")
    private Integer viewX;
    @ApiModelProperty(value = "相机y坐标")
    private Integer viewY;
    @ApiModelProperty(value = "相机z坐标")
    private Integer viewZ;
    @ApiModelProperty(value = "看向x坐标")
    private Integer lookatX;
    @ApiModelProperty(value = "看向y坐标")
    private Integer lookatY;
    @ApiModelProperty(value = "看向z坐标")
    private Integer lookatZ;
}
