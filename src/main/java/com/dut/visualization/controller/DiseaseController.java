package com.dut.visualization.controller;

import com.dut.visualization.dto.DiseaseLocationDTO;
import com.dut.visualization.service.impl.DiseaseServiceImpl;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 10:20 上午 2023/4/27
 * @ Description：病害信息接口
 * @Version: 1.0.0$
 */
@Api(tags = "监测信息接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/disease")
public class DiseaseController {
    @Resource
    private DiseaseServiceImpl diseaseServiceImpl;

    @ApiOperation(value = "查询病害坐标及严重程度", tags = {"病害信息页","已通"})
    @GetMapping("/get_disease_location")
    public ResponseViewModel<List<DiseaseLocationDTO>> getDiseaseLocation(@RequestParam String startTime, @RequestParam String endTime){
        List<DiseaseLocationDTO> diseaseLocationDTOS = diseaseServiceImpl.getDiseaseLocationList(startTime,endTime);
        return ResponseViewModel.ok(diseaseLocationDTOS);
    }
}
