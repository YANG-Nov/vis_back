package com.dut.visualization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.Sensor;
import com.dut.visualization.dto.SensorInfoDTO;
import com.dut.visualization.dto.SensorNumDTO;
import com.dut.visualization.dto.SensorPositionDTO;
import com.dut.visualization.mapper.SensorMapper;
import com.dut.visualization.service.SensorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 6:12 下午 2023/5/31
 * @ Description：
 * @Version: $
 */
@Slf4j
@Service
public class SensorServiceImpl   extends ServiceImpl<SensorMapper, Sensor> implements SensorService {
    //传感器定位
    @Override
    public List<SensorPositionDTO> getSensorPosition() {
        return baseMapper.selectSensorPosition();
    }
    //传感器数量锥形图
    @Override
    public List<SensorNumDTO> getSensorNumChartList() {
        return baseMapper.selectSensorNumChartList();
    }
    //传感器信息
    @Override
    public SensorInfoDTO getSensorInfo(String sensorModelCode) { return baseMapper.selectSensorInfo(sensorModelCode); }
}
