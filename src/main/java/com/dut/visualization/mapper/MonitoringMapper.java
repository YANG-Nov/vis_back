package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.MonitoringData;
import com.dut.visualization.dto.MonitoringDataDTO;


public interface MonitoringMapper extends BaseMapper<MonitoringData> {
    MonitoringDataDTO selectMonitoringData(String sensorCode);
}
