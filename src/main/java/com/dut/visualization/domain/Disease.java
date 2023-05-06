package com.dut.visualization.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 10:23 上午 2023/4/27
 * @ Description：病害
 * @Version: 1.0.0$
 */
@Data
@TableName("vis_specific_disease_info")
@NoArgsConstructor
@AllArgsConstructor
public class Disease {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "病害id")
    private String diseaseId;

    @ApiModelProperty(value = "任务id")
    private String taskId;

    @ApiModelProperty(value = "具体构件id")
    private String specificComponentId;

    @ApiModelProperty(value = "模型编码")
    private String modelCode;

    @ApiModelProperty(value = "病害编码")
    private String diseaseCode;

    @ApiModelProperty(value = "x")
    private double x;

    @ApiModelProperty(value = "y")
    private double y;

    @ApiModelProperty(value = "z")
    private double z;

    @ApiModelProperty(value = "病害程度 0轻微 1一般 2严重")
    private int degree;

    @ApiModelProperty(value = "是否修复 0未修 1已修复")
    private int isRepair;

    @ApiModelProperty(value = "逻辑删除 0未删 1删")
    private String isDeleted;

    @ApiModelProperty(value = "创建时间")
    private String createTime;


}
