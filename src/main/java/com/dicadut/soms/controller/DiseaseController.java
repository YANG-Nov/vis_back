package com.dicadut.soms.controller;


import com.dicadut.soms.dto.DiseaseAppListDTO;
import com.dicadut.soms.dto.DiseaseAttributeListDTO;
import com.dicadut.soms.service.DiseaseService;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
@Api(tags = "病害接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("disease")
public class DiseaseController {


    @Resource
    private DiseaseService diseaseService;

    @ApiOperation("查询病害")
    @GetMapping("getFrequency")
    @Deprecated
    public ResponseViewModel<List<DiseaseAppListDTO>> getDisease() {
        List<DiseaseAppListDTO> diseaseLatestList = diseaseService.getDiseaseList();
        return ResponseViewModel.ok(diseaseLatestList);
    }

    @ApiOperation(value = "App添加病害，不同构件对应的病害列表", tags = {"App","YANG","App已通"})
    @GetMapping("get_component_disease_app_list")
    public ResponseViewModel<List<DiseaseAppListDTO>> getComponentDiseaseAppList(@RequestParam Integer componentId) {
        List<DiseaseAppListDTO> diseaseAppList = diseaseService.getDiseaseAppList(componentId);
        return ResponseViewModel.ok(diseaseAppList);
    }

    @ApiOperation(value = "App添加病害，不同病害对应的病害属性列表", tags = {"App","YANG","App已通"})
    @GetMapping("get_disease_attribute_app_list")
    public ResponseViewModel<List<DiseaseAttributeListDTO>> getDiseaseAttributeAppList(@RequestParam Integer diseaseId) {
        List<DiseaseAttributeListDTO> diseaseAttributeAppList = diseaseService.getDiseaseAttributeAppList(diseaseId);
        return ResponseViewModel.ok(diseaseAttributeAppList);
    }
}

