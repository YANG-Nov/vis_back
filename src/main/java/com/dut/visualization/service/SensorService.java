package com.dut.visualization.service;

import com.dut.visualization.dto.SensorInfoDTO;
import com.dut.visualization.dto.SensorNumDTO;
import com.dut.visualization.dto.SensorPositionDTO;

import java.util.List;

public interface SensorService {
    //传感器定位
    List<SensorPositionDTO> getSensorPosition();
    //传感器数量锥形图
    List<SensorNumDTO> getSensorNumChartList();
    //传感器信息
    SensorInfoDTO getSensorInfo(String sensorModelCode);
}
