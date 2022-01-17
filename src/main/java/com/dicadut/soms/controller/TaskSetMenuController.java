package com.dicadut.soms.controller;


import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.service.TaskSetMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 任务套餐表 前端控制器
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-17
 */
@Api(tags = "任务套餐接口")
@Slf4j
@RestController
@RequestMapping("/menu")
public class TaskSetMenuController {
    //访问地址 ：http://localhost:8089/menu
    //注入service
    @Autowired
    private TaskSetMenuService taskSetMenuService;

    /**
     *TODO 需要优化
     *
     * @author fan_jane
     */
    @ApiOperation("制定任务添加任务页添加套餐")
    @PostMapping("/addMenu")
    public ResponseViewModel addMenu(@RequestBody List<ComponentDTO> componentDTOList) {
        taskSetMenuService.saveTaskMenu(componentDTOList);
        return ResponseViewModel.ok();

    }
}

