package com.dut.visualization.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:49 下午 2023/4/6
 * @ Description：监测数据表
 * @Version: $
 */
@Data
@TableName("vis_monitoring")
@NoArgsConstructor
@AllArgsConstructor
public class MonitoringData {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "传感器id")
    private String sensorId;

    @ApiModelProperty(value = "x")
    private String x;

    @ApiModelProperty(value = "y")
    private String y;
}
