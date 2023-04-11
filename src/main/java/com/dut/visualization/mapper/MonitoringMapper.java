package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.MonitoringData;
import com.dut.visualization.dto.MonitoringDataDTO;
import com.dut.visualization.dto.SensorAlarmDTO;
import com.dut.visualization.dto.SensorNumDTO;
import com.dut.visualization.dto.SensorStatusDTO;

import java.util.List;


public interface MonitoringMapper extends BaseMapper<MonitoringData> {
    //查看传感器数据
    List<MonitoringDataDTO> selectMonitoringDataList(String sensorModelCode);
    //查看传感器状态扇形图
    List<SensorStatusDTO> selectSensorStatusChartList();
    //查看传感器数量扇形图
    List<SensorNumDTO> selectSensorNumChartList();
    //查看传感器报警信息扇形图
    List<SensorAlarmDTO> selectSensorAlarmChartList();
}
