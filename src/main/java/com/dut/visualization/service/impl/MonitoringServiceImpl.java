package com.dut.visualization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.MonitoringData;
import com.dut.visualization.dto.MonitoringDataDTO;
import com.dut.visualization.mapper.MonitoringMapper;
import com.dut.visualization.service.MonitoringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:12 下午 2023/4/6
 * @ Description：
 * @Version: $
 */
@Slf4j
@Service
public class MonitoringServiceImpl  extends ServiceImpl<MonitoringMapper, MonitoringData> implements MonitoringService {
    //查看传感器数据
    @Override
    public List<MonitoringDataDTO> getMonitoringDataList(String sensorCode) {
        return baseMapper.selectMonitoringDataList(sensorCode);
    }
}
