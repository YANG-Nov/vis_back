package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.Sensor;
import com.dut.visualization.dto.SensorInfoDTO;
import com.dut.visualization.dto.SensorNumDTO;
import com.dut.visualization.dto.SensorPositionDTO;

import java.util.List;

public interface SensorMapper extends BaseMapper<Sensor> {
    //传感器定位
    List<SensorPositionDTO> selectSensorPosition();
    //查看传感器数量扇形图
    List<SensorNumDTO> selectSensorNumChartList();
    //传感器信息
    SensorInfoDTO selectSensorInfo(String sensorModelCode);
}
