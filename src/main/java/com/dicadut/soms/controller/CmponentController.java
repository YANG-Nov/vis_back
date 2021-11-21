package com.dicadut.soms.controller;

import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.CmponentDTO;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.entity.Cmponent;
import com.dicadut.soms.service.CmponentService;
import com.dicadut.soms.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 13:59
 */
@Api(tags = "构件管理接口")
@Slf4j
@RestController
@RequestMapping("/component")
public class CmponentController {
    @Autowired
    private CmponentService cmponentService;

    @ApiOperation("查询构件巡检频率")
    @GetMapping("getFrequency")
    public ResponseViewModel<List<CmponentDTO>> getFrequencyList() {
        List<CmponentDTO> frequencyLatestList = cmponentService.getFrequencyList();
        return ResponseViewModel.ok(frequencyLatestList);

    }
}
