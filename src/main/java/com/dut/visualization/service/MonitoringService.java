package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.MonitoringData;
import com.dut.visualization.dto.MonitoringDataDTO;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:45 下午 2023/4/6
 * @ Description：
 * @Version: $
 */
public interface MonitoringService  extends IService<MonitoringData> {
    List<MonitoringDataDTO> getMonitoringDataList(String sensorCode);
}
