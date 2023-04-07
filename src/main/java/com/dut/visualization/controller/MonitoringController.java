package com.dut.visualization.controller;

import com.dut.visualization.dto.MonitoringDataDTO;
import com.dut.visualization.service.impl.MonitoringServiceImpl;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 4:10 下午 2023/4/6
 * @ Description：监测信息接口
 * @Version: 1.0.0$
 */
@Api(tags = "具体构件信息接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/monitoring")
public class MonitoringController {
    @Resource
    private MonitoringServiceImpl monitoringServiceImpl;

    @ApiOperation(value = "getMonitoringData", tags = {"首页","未通"})
    @GetMapping("/get_monitoring_data/{sensorCode}")
    public ResponseViewModel<List<MonitoringDataDTO>> getMonitoringData(@PathVariable String sensorCode) {
        List<MonitoringDataDTO> monitoringDataDTOList = monitoringServiceImpl.getMonitoringDataList(sensorCode);
        return ResponseViewModel.ok(monitoringDataDTOList);
    }
}
