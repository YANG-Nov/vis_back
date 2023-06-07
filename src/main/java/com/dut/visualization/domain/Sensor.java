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
 * @ Date       ：Created in 6:14 下午 2023/5/31
 * @ Description：传感器
 * @Version: $
 */
@Data
@TableName("vis_sensor")
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "传感器id")
    private String sensorId;

    @ApiModelProperty(value = "在线情况 0在线1不在线")
    private String online;

    @ApiModelProperty(value = "报警情况 0正常1一级预警2二级预警")
    private String alarm;

    @ApiModelProperty(value = "阈值")
    private String threshold;

    @ApiModelProperty(value = "模型编码")
    private String modelCode;

    @ApiModelProperty(value = "功能")
    private String function;

    @ApiModelProperty(value = "厂家")
    private String manufacturer;

    @ApiModelProperty(value = "测点")
    private String monitoringPoint;

    @ApiModelProperty(value = "传感器位置x坐标")
    private String x;

    @ApiModelProperty(value = "传感器位置y坐标")
    private String y;

    @ApiModelProperty(value = "传感器位置z坐标")
    private String z;

    @ApiModelProperty(value = "传感器位置x坐标")
    private String isDeleted;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;
}
