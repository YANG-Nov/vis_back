package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 11:32 上午 2023/5/19
 * @ Description：查询主体、接头、附属分别有哪些病害类型
 * @Version: $
 */
@Data
public class DiseaseTypeDTO {
    @ApiModelProperty(value = "病害类型名称")
    private String name;

    @ApiModelProperty(value = "病害类型id")
    private String id;
}
