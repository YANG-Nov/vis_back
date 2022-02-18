package com.dicadut.soms.controller;

import com.dicadut.soms.dto.StrainResDTO;
import com.dicadut.soms.service.StrainService;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:56:28
 */
@Api(tags = "_北大桥应力传感器接口")
@Slf4j
@RestController
@RequestMapping("/api")
public class StrainController {

    @Resource
    private StrainService strainService;

    @ApiOperation("获取最新的传感器数据")
    @GetMapping("/strain_latest")
    public ResponseViewModel<List<StrainResDTO>> getStrainLatest(@RequestParam Integer pageSize) {
        return ResponseViewModel.ok(strainService.getStrainLatest(pageSize));
    }

    @ApiOperation("根据时间范围查询应力传感器数据")
    @GetMapping("/strain")
    public ResponseViewModel<List<StrainResDTO>> getStrainList(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseViewModel.ok(strainService.getStrainList(startTime, endTime));
    }

}
