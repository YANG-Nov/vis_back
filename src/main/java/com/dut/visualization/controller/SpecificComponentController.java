package com.dut.visualization.controller;

import com.dut.visualization.dto.ComponentInformationDTO;
import com.dut.visualization.service.SpecificComponentService;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@RequestMapping("/specific_component")
public class SpecificComponentController {
    @Resource
    private SpecificComponentService specificComponentService;

    @ApiOperation(value = "getComponentInformation", tags = {"首页","未通"})
    @GetMapping("/get_component_information/{specificComponentId}")
    public ResponseViewModel<ComponentInformationDTO> getComponentInformation(@PathVariable String specificComponentId) {
        ComponentInformationDTO componentInformationDTO = specificComponentService.getComponentInformation(specificComponentId);
        return ResponseViewModel.ok(componentInformationDTO);
    }
}
