package com.dut.visualization.controller;

import com.dut.visualization.dto.MonitoringDataDTO;
import com.dut.visualization.dto.SensorAlarmDTO;
import com.dut.visualization.dto.SensorNumDTO;
import com.dut.visualization.dto.SensorStatusDTO;
import com.dut.visualization.service.impl.MonitoringServiceImpl;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:10 下午 2023/4/6
 * @ Description：监测信息接口
 * @Version: 1.0.0$
 */
@Api(tags = "监测信息接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/monitoring")
public class MonitoringController {
    @Resource
    private MonitoringServiceImpl monitoringServiceImpl;

    /**
     * 根据传感器模型编码查找传感器数据
     * @param sensorModelCode 传感器模型编码
     * @return 传感器数据
     */
    @ApiOperation(value = "查找传感器数据", tags = {"监测信息页","已通"})
    @GetMapping("/get_monitoring_data/{sensorModelCode}")
    public ResponseViewModel<List<MonitoringDataDTO>> getMonitoringData(@PathVariable String sensorModelCode) {
        List<MonitoringDataDTO> monitoringDataDTOList = monitoringServiceImpl.getMonitoringDataList(sensorModelCode);
        return ResponseViewModel.ok(monitoringDataDTOList);
    }

    /**
     * 查询传感器状态扇形图
     * @return 传感器状态及不同状态所对应的数量
     */
    @ApiOperation(value = "查询传感器状态扇形图", tags = {"监测信息页","未通"})
    @GetMapping("/get_sensor_status_chart")
    public ResponseViewModel<List<SensorStatusDTO>> getSensorStatusChart(){
        List<SensorStatusDTO> sensorStatusList = monitoringServiceImpl.getSensorStatusChartList();
        return ResponseViewModel.ok(sensorStatusList);
    }

    /**
     * 查询传感器不同类型数量扇形图
     * @return 传感器类型及不同类型所对应的数量
     */
    @ApiOperation(value = "查询传感器不同类型数量扇形图", tags = {"监测信息页","未通"})
    @GetMapping("/get_sensor_Num_chart")
    public ResponseViewModel<List<SensorNumDTO>> getSensorNumChart(){
        List<SensorNumDTO> sensorNumList = monitoringServiceImpl.getSensorNumChartList();
        return ResponseViewModel.ok(sensorNumList);
    }

    /**
     * 查询传感器报警数量扇形图
     * @return 传感器报警类型及不同类型所对应的数量
     */
    @ApiOperation(value = "查询传感器报警数量扇形图", tags = {"监测信息页","未通"})
    @GetMapping("/get_sensor_Alarm_chart")
    public ResponseViewModel<List<SensorAlarmDTO>> getSensorAlarmChart(){
        List<SensorAlarmDTO> sensorAlarmList = monitoringServiceImpl.getSensorAlarmChartList();
        return ResponseViewModel.ok(sensorAlarmList);
    }
}
