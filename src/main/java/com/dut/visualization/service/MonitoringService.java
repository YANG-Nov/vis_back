package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.MonitoringData;
import com.dut.visualization.domain.SpecificComponent;
import com.dut.visualization.dto.MonitoringDataDTO;
import com.dut.visualization.dto.SpecificComponentInformationDTO;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:45 下午 2023/4/6
 * @ Description：
 * @Version: $
 */
public interface MonitoringService  extends IService<MonitoringData> {
    MonitoringDataDTO getMonitoringData(String sensorCode);

//    MonitoringDataDTO getMonitoringDataDTO(String sensorCode);
}
