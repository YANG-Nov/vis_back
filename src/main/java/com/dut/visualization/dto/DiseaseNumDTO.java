package com.dut.visualization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:20 下午 2023/11/2
 * @ Description：病害首页 病害数量统计
 * @Version: 1.0.0$
 */
@Data
public class DiseaseNumDTO {
//    private List<Item> diseaseNum;
//
//    @Data
//    public static class Item {
//        private String name;
//        private Integer value;
//    }
    @ApiModelProperty(value = "主体结构病害数量")
    private Integer diseaseZtNum;

    @ApiModelProperty(value = "接头部位病害数量")
    private Integer diseaseJtNum;

    @ApiModelProperty(value = "附属结构病害数量")
    private Integer diseaseFsNum;

    @ApiModelProperty(value = "病害总数量")
    private Integer diseaseTotalNum;
}
