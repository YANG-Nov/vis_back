package com.dicadut.soms.controller;


import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.BLineStakeNumberMinMaxDTO;
import com.dicadut.soms.dto.InspectionFrequencyDTO;
import com.dicadut.soms.dto.TaskTypeDTO;
import com.dicadut.soms.service.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-03
 */
@Api(tags = "t字典接口")
@Slf4j
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
    //访问地址 ：http://localhost:8089/dictionary
    //注入service
    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation("制定任务页显示构件频率")
    @GetMapping("getComponentsFrequency")
    public ResponseViewModel<List<InspectionFrequencyDTO>> getComponentsFrequency() {
        return ResponseViewModel.ok(dictionaryService.getComponentsFrequency());
    }

    /**
     * TODO 可以和getcomponentFrquency合成一个接口吗
     */
    @ApiOperation("制定任务页显示任务类型")
    @GetMapping("getTaskType")
    public ResponseViewModel<List<TaskTypeDTO>> getTaskType() {
        return ResponseViewModel.ok(dictionaryService.getTaskType());
    }

    /**
     * TODO
     * AB可以共用一个接口吗
     */
/*    @ApiOperation("制定任务页显示B匝道下拉桩号")
    @GetMapping("getBLineStakeNumber")
    public ResponseViewModel<List<BLineStakeNumberDTO>> getBLineStakeNumber() {
        return ResponseViewModel.ok(dictionaryService.getBLineStakeNumber());
    }*/
    @ApiOperation("制定任务页显示B匝道下拉桩号")
    @GetMapping("getBLineStakeNumber")
    public ResponseViewModel<BLineStakeNumberMinMaxDTO> getBLineStakeNumberMinMax() {
        return ResponseViewModel.ok(dictionaryService.getBLineStakeNumberMinMax());
    }


}

