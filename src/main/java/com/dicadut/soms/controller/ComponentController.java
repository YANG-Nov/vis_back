package com.dicadut.soms.controller;

import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.ComponentAppListDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.dto.ComponentPositionAppListDTO;
import com.dicadut.soms.service.ComponentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 21/11/21 13:59
 */
@Api(tags = "构件管理接口")
@Slf4j
@RestController
@RequestMapping("/component")
public class ComponentController {
    @Autowired
    private ComponentService componentService;
    /**
     *
     *
     * @author fan_jane
     */
    @ApiOperation("获得构件巡检频率")
    @GetMapping("getFrequency")
    public ResponseViewModel<List<ComponentDTO>> getFrequencyList() {
        List<ComponentDTO> frequencyLatestList = componentService.getFrequencyList();
        return ResponseViewModel.ok(frequencyLatestList);

    }
    /**
     *
     *
     * @author fan_jane
     */
    @ApiOperation("任务添加页面的构件显示")
    @GetMapping("getStakeNumberListByLine")
    public ResponseViewModel<List<ComponentDTO>> getStakeNumberListByLine() {
        List<ComponentDTO> frequencyLatestList = componentService.getFrequencyList();
        return ResponseViewModel.ok(frequencyLatestList);

    }

    @ApiOperation("App添加病害前，选择构件列表")
    @GetMapping("getComponentAppList")
    public ResponseViewModel<List<ComponentAppListDTO>> getComponentAppList(@RequestParam Integer componentId) {
        List<ComponentAppListDTO> componentAppList = componentService.getComponentAppList(componentId);
        return ResponseViewModel.ok(componentAppList);
    }

    @ApiOperation("APP添加病害页面，选择构件位置")
    @GetMapping("getComponentPositionAppList")
    public ResponseViewModel<List<ComponentPositionAppListDTO>> getComponentPositionAppList(@RequestParam String taskId
                                                                                            ,@RequestParam String componentId) {
        List<ComponentPositionAppListDTO> componentPositionAppList = componentService.getComponentPositionAppList(taskId,componentId);
        return ResponseViewModel.ok(componentPositionAppList);
    }
}
