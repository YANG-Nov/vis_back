package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 12:28 下午 2023/5/8
 * @ Description：病害信息页 数据分类统计柱状图
 * @Version: $
 */
@Data
public class DiseaseTypeDTO {
    @ApiModelProperty(value = "病害类型")
    private String name;

    @ApiModelProperty(value = "病害数量")
    private String value;
}
