package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 9:00 上午 2022/1/29
 * @ Description：查看病害详情，eg：图片等
 * @Version: 1.0.0$
 */
@ApiModel("查看病害详情，eg：图片等")
@Data
public class DiseaseDetailsDTO {
    @ApiModelProperty(value = "病害属性id")
    private String diseaseAttributeId;
    @ApiModelProperty(value = "病害属性")
    private String diseaseAttributeName;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "内容种类")
    private String type;
}
