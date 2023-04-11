package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.MonitoringData;
import com.dut.visualization.dto.MonitoringDataDTO;
import com.dut.visualization.dto.SensorAlarmDTO;
import com.dut.visualization.dto.SensorNumDTO;
import com.dut.visualization.dto.SensorStatusDTO;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:45 下午 2023/4/6
 * @ Description：
 * @Version: $
 */
public interface MonitoringService  extends IService<MonitoringData> {
    //查看传感器数据
    List<MonitoringDataDTO> getMonitoringDataList(String sensorCode);
    //传感器状态扇形图
    List<SensorStatusDTO> getSensorStatusChartList();
    //传感器数量扇形图
    List<SensorNumDTO> getSensorNumChartList();
    //传感器报警信息扇形图
    List<SensorAlarmDTO> getSensorAlarmChartList();
}
