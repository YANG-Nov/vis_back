package com.dut.visualization.controller;

import com.dut.visualization.dto.CameraPositionDTO;
import com.dut.visualization.dto.SpecificComponentInformationDTO;
import com.dut.visualization.dto.SpecificTubeDTO;
import com.dut.visualization.service.SpecificComponentService;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:18 下午 2022/5/19
 * @ Description：
 * @Version: $
 */
@Api(tags = "具体构件信息接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/specific_component")
public class SpecificComponentController {
    @Resource
    private SpecificComponentService specificComponentService;

    /**
     * 根据构件模型编码查构件基本信息
     * @param componentModelCode 构件模型编码
     * @return 构件基本信息
     */
    @ApiOperation(value = "根据构件模型编码查构件基本信息", tags = {"首页","已通"})
    @GetMapping("/get_specific_component_information/{componentModelCode}")
    public ResponseViewModel<SpecificComponentInformationDTO> getSpecificComponentInformation(@PathVariable String componentModelCode) {
        SpecificComponentInformationDTO specificComponentInformationDTO = specificComponentService.getSpecificComponentInformation(componentModelCode);
        return ResponseViewModel.ok(specificComponentInformationDTO);
    }

    /**
     * 查询有哪些管节
     * @return componentId componentName
     */
    @ApiOperation(value = "查询有哪些管节", tags = {"首页","已通"})
    @GetMapping("/get_tube")
    public ResponseViewModel<List<SpecificTubeDTO>> getSpecificTube() {
        List<SpecificTubeDTO> specificTubeDTOs = specificComponentService.getSpecificTube();
        return ResponseViewModel.ok(specificTubeDTOs);
    }

    /**
     * 查询管节对应的相机位置
     * @param specificComponentId 构件模型编码
     * @return
     */
    @ApiOperation(value = "查询管节对应的相机位置", tags = {"首页","已通"})
    @GetMapping("/get_view/{specificComponentId}")
    public ResponseViewModel<CameraPositionDTO> getView(@PathVariable String specificComponentId) {
        CameraPositionDTO cameraPositionDTO = specificComponentService.getView(specificComponentId);
        return ResponseViewModel.ok(cameraPositionDTO);
    }
}
