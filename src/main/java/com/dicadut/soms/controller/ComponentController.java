package com.dicadut.soms.controller;

import cn.hutool.core.lang.tree.Tree;
import com.dicadut.soms.dto.ComponentAppListDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.dto.ComponentPositionAppListDTO;
import com.dicadut.soms.service.ComponentService;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 21/11/21 13:59
 */
@Api(tags = "构件接口")
@Slf4j
@RestController
@RequestMapping("/component")
public class ComponentController {

    @Resource
    private ComponentService componentService;

    /**
     * 数据库变动待修改
     * @author fan_jane
     */
    @ApiOperation("获得构件巡检频率")
    @GetMapping("getFrequency")
    @Deprecated
    public ResponseViewModel<List<ComponentDTO>> getFrequencyList() {
        List<ComponentDTO> frequencyLatestList = componentService.getFrequencyList();
        return ResponseViewModel.ok(frequencyLatestList);

    }

    /**
     * App添加病害前，选择构件列表（巡检内容）
     * @param taskId 任务id
     * @return 构件列表，树形结构
     */
    //TODO 树形结构 任务巡检内容 //FIX
    @ApiOperation("App添加病害前，选择构件列表（巡检内容）")
    @GetMapping("get_component_app_list")
    public ResponseViewModel<List<Tree<Integer>>> getComponentAppList(@RequestParam String taskId) {
        return ResponseViewModel.ok(componentService.getComponentAppList(taskId));
    }

    /**
     * APP添加病害页面，选择构件位置
     * @param taskId 任务id
     * @param componentId 构件id
     * @return 构件所对应的桩号列表
     */
    @ApiOperation("APP添加病害页面，选择构件位置")
    @GetMapping("get_component_position_app_list")
    public ResponseViewModel<List<ComponentPositionAppListDTO>> getComponentPositionAppList(@RequestParam String taskId
            , @RequestParam String componentId) {
        List<ComponentPositionAppListDTO> componentPositionAppList = componentService.getComponentPositionAppList(taskId, componentId);
        return ResponseViewModel.ok(componentPositionAppList);
    }
}
