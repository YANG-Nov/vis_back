package com.dut.visualization.controller;

import com.dut.visualization.dto.SensorNumDTO;
import com.dut.visualization.dto.SensorPositionDTO;
import com.dut.visualization.service.impl.MonitoringServiceImpl;
import com.dut.visualization.service.impl.SensorServiceImpl;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 6:10 下午 2023/5/31
 * @ Description：传感器表
 * @Version: 1.0.0$
 */
@Api(tags = "传感器接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/sensor")
public class SensorController {
    @Resource
    private SensorServiceImpl sensorServiceImpl;
    /**
     * 传感器定位
     * @return 传感器坐标、状态、预警、测点信息
     */
    @ApiOperation(value = "传感器定位", tags = {"监测信息页","已通"})
    @GetMapping("/get_sensor_position")
    public ResponseViewModel<List<SensorPositionDTO>> getSensorPosition(){
        List<SensorPositionDTO> sensorPositionList = sensorServiceImpl.getSensorPosition();
        return ResponseViewModel.ok(sensorPositionList);
    }
    /**
     * 查询传感器不同类型数量扇形图
     * @return 传感器类型及不同类型所对应的数量
     */
    @ApiOperation(value = "查询传感器不同类型数量锥形图", tags = {"监测信息页","已通"})
    @GetMapping("/get_sensor_num_chart")
    public ResponseViewModel<List<SensorNumDTO>> getSensorNumChart(){
        List<SensorNumDTO> sensorNumList = sensorServiceImpl.getSensorNumChartList();
        return ResponseViewModel.ok(sensorNumList);
    }
}
