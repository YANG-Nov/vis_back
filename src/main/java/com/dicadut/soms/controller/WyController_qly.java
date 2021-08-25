package com.dicadut.soms.controller;

import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.WyResDTO_qly;
import com.dicadut.soms.service.WyService_qly;
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
@Api(tags = "大连湾大桥应力传感器接口")
@Slf4j
@RestController
@RequestMapping("/api")
public class WyController_qly {
    @Resource
    private WyService_qly wyService;

    @ApiOperation("获取最新的传感器数据")
    @GetMapping("/Wy_latest")
    public ResponseViewModel<List<WyResDTO_qly>> getWyLatest(@RequestParam Integer pageSize) {
        return ResponseViewModel.ok(wyService.getWyLatest(pageSize));
    }

    @ApiOperation("根据时间范围查询应力传感器数据")
    @GetMapping("/Wy")
    public ResponseViewModel<List<WyResDTO_qly>> getWyList(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseViewModel.ok(wyService.getWyList(startTime, endTime));
    }
}
