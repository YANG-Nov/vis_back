package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 12:21 下午 2022/1/27
 * @ Description：App添加病害后显示病害记录表
 * @Version: 1.0.0$
 */
@Data
public class DiseaseRecordAppListDTO {
    @ApiModelProperty("构件名称")
    private String component;
    @ApiModelProperty("构件id")
    private String componentId;
    @ApiModelProperty("病害名称")
    private String disease;
    @ApiModelProperty("病害id")
    private String diseaseId;
    @ApiModelProperty("病害位置")
    private String position;
    @ApiModelProperty("病害id")
    private String positionId;
}
