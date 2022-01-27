package com.dicadut.soms.controller;

import com.dicadut.soms.viewmodel.ResponseViewModel;
import com.dicadut.soms.dto.WyResDTO;
import com.dicadut.soms.service.WyService;
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
 * @author Yang
 * @Description TODO
 * @create 2021-08-25 16:47
 */
@Api(tags = "大连湾大桥位移传感器接口")
@Slf4j
@RestController
@RequestMapping("/api")
public class WyController {
    @Resource
    private WyService wyService;

    @ApiOperation("获取最新的传感器数据")
    @GetMapping("/wy_latest")
    public ResponseViewModel<List<WyResDTO>> getWyLatest(@RequestParam Integer pageSize) {
        return ResponseViewModel.ok(wyService.getWyLatest(pageSize));
    }

    @ApiOperation("根据时间范围查询位移传感器数据")
    @GetMapping("/wy")
    public ResponseViewModel<List<WyResDTO>> getWyList(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseViewModel.ok(wyService.getWyList(startTime, endTime));
    }
}
