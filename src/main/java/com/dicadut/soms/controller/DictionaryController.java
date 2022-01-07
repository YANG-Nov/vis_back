package com.dicadut.soms.controller;


import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.InspectionFrequencyDTO;
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


}

