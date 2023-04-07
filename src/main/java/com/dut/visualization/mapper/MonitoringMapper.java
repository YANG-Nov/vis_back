package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.MonitoringData;
import com.dut.visualization.dto.MonitoringDataDTO;

import java.util.List;


public interface MonitoringMapper extends BaseMapper<MonitoringData> {
    List<MonitoringDataDTO> selectMonitoringDataList(String sensorCode);
}
