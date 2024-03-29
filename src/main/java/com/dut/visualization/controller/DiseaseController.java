package com.dut.visualization.controller;

import com.dut.visualization.dto.*;
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
@Api(tags = "病害信息接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/disease")
public class DiseaseController {
    @Resource
    private DiseaseServiceImpl diseaseServiceImpl;

    @ApiOperation(value = "查询病害坐标、类型及严重程度", tags = {"病害信息页", "已通"})
    @GetMapping("/get_disease_location")
    public ResponseViewModel<List<DiseaseLocationDTO>> getDiseaseLocation(@RequestParam String startTime, @RequestParam String endTime) {
        List<DiseaseLocationDTO> diseaseLocationDTOS = diseaseServiceImpl.getDiseaseLocationList(startTime, endTime);
        return ResponseViewModel.ok(diseaseLocationDTOS);
    }

    @ApiOperation(value = "查询主体、接头、附属分别有哪些病害类型", tags = {"病害信息页", "已通"})
    @GetMapping("/get_disease_type")
    public ResponseViewModel<List<DiseaseTypeDTO>> getDiseaseType(@RequestParam String diseaseTypeId) {
        List<DiseaseTypeDTO> diseaseTypeDTOS = diseaseServiceImpl.getDiseaseTypeList(diseaseTypeId);
        return ResponseViewModel.ok(diseaseTypeDTOS);
    }

    @ApiOperation(value = "病害部位-数量统计（主体、接头、附属）", tags = {"病害信息页", "已通"})
    @GetMapping("/get_disease_place_num")
    public ResponseViewModel<List<DiseasePlaceNumDTO>> getDiseasePlaceNum(@RequestParam String startTime, @RequestParam String endTime) {
        List<DiseasePlaceNumDTO> diseasePlaceNumDTOS = diseaseServiceImpl.getDiseasePlaceNumList(startTime, endTime);
        return ResponseViewModel.ok(diseasePlaceNumDTOS);
    }

    @ApiOperation(value = "病害类型-数量统计", tags = {"病害信息页", "已通"})
    @GetMapping("/get_disease_type_num")
    public ResponseViewModel<List<DiseaseTypeNumDTO>> getDiseaseTypeNum(@RequestParam String diseaseParentId,
                                                                        @RequestParam String startTime,
                                                                        @RequestParam String endTime) {
        List<DiseaseTypeNumDTO> diseaseTypeNumDTOS = diseaseServiceImpl.getDiseaseTypeNumList(diseaseParentId, startTime, endTime);
        return ResponseViewModel.ok(diseaseTypeNumDTOS);
    }

    @ApiOperation(value = "主体结构病害发生时间统计", tags = {"病害信息页", "已通"})
    @GetMapping("/get_disease_zt_time")
    public ResponseViewModel<List<DiseaseZtTimeDTO>> getDiseaseZtTime(@RequestParam String startTime, @RequestParam String endTime) {
        List<DiseaseZtTimeDTO> diseaseZtTimeDTOS = diseaseServiceImpl.getDiseaseZtTimeList(startTime, endTime);
        return ResponseViewModel.ok(diseaseZtTimeDTOS);
    }

    @ApiOperation(value = "病害发生位置-数量统计", tags = {"病害信息页", "已通"})
    @GetMapping("/get_disease_position_num")
    public ResponseViewModel<List<DiseasePositionNumDTO>> getDiseasePositionNum(@RequestParam String startTime, @RequestParam String endTime) {
        List<DiseasePositionNumDTO> diseasePositionNumDTOS = diseaseServiceImpl.getDiseasePositionNum(startTime, endTime);
        return ResponseViewModel.ok(diseasePositionNumDTOS);
    }

    @ApiOperation(value = "病害严重程度-数量统计", tags = {"病害信息页", "已通"})
    @GetMapping("/get_disease_degree_num")
    public ResponseViewModel<List<DiseaseDegreeNumDTO>> getDiseaseDegreeNum(@RequestParam String startTime, @RequestParam String endTime) {
        List<DiseaseDegreeNumDTO> diseaseDegreeNumDTOS = diseaseServiceImpl.getDiseaseDegreeNum(startTime, endTime);
        return ResponseViewModel.ok(diseaseDegreeNumDTOS);
    }

    @ApiOperation(value = "病害发生时间-数量统计", tags = {"病害信息页", "已通"})
    @GetMapping("/get_disease_time_num")
    public ResponseViewModel<List<DiseaseTimeNumDTO>> getDiseaseTimeNum(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String diseaseId) {
        List<DiseaseTimeNumDTO> diseaseTimeNumDTOS = diseaseServiceImpl.getDiseaseTimeNum(startTime, endTime, diseaseId);
        log.info("返回给前端的数据 diseaseTimeNumDTOS:{}", diseaseTimeNumDTOS);
        return ResponseViewModel.ok(diseaseTimeNumDTOS);
    }

    @ApiOperation(value = "单个病害详情（病害历史）", tags = {"病害信息页", "未通"})
    @GetMapping("/get_disease_info_history")
    public ResponseViewModel<List<DiseaseInfoHistoryListDTO>> getDiseaseInfoHistory(@RequestParam String diseaseModelCode) {
        List<DiseaseInfoHistoryDTO> diseaseInfoHistoryDTOS = diseaseServiceImpl.getDiseaseInfoHistory(diseaseModelCode);
        List<DiseaseInfoHistoryListDTO> list = DiseaseInfoHistoryListDTO.convert(diseaseInfoHistoryDTOS);
        return ResponseViewModel.ok(list);
    }

    @ApiOperation(value = "病害首页，病害数量", tags = {"首页", "未通"})
    @GetMapping("/get_disease_num")
    public ResponseViewModel<List<DiseaseNumDTO>> getDiseaseNum() {
        List<DiseaseNumDTO> diseaseNumDTOS = diseaseServiceImpl.getDiseaseNum();
        return ResponseViewModel.ok(diseaseNumDTOS);
    }
}
