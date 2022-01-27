package com.dicadut.soms.controller;


import com.dicadut.soms.viewmodel.ResponseViewModel;
import com.dicadut.soms.dto.DiseaseAppListDTO;
import com.dicadut.soms.dto.DiseaseAttributeListDTO;
import com.dicadut.soms.service.DiseaseService;
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
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
@Api(tags = "病害管理接口")
@Slf4j
@RestController
@RequestMapping("disease")
public class DiseaseController {


    @Resource
    private DiseaseService diseaseService;

    @ApiOperation("查询病害")
    @GetMapping("getFrequency")
    public ResponseViewModel<List<DiseaseAppListDTO>> getDisease() {
        List<DiseaseAppListDTO> diseaseLatestList = diseaseService.getDiseaseList();
        return ResponseViewModel.ok(diseaseLatestList);
    }

    @ApiOperation("App添加病害，不同构件对应的病害列表")
    @GetMapping("getComponentDiseaseAppList")
    public ResponseViewModel<List<DiseaseAppListDTO>> getComponentDiseaseAppList(@RequestParam Integer componentId) {
        List<DiseaseAppListDTO> diseaseAppList = diseaseService.getDiseaseAppList(componentId);
        return ResponseViewModel.ok(diseaseAppList);
    }

    @ApiOperation("App添加病害，不同病害对应的病害属性列表")
    @GetMapping("getDiseaseAttributeAppList")
    public ResponseViewModel<List<DiseaseAttributeListDTO>> getDiseaseAttributeAppList(@RequestParam Integer diseaseId) {
        List<DiseaseAttributeListDTO> diseaseAttributeAppList = diseaseService.getDiseaseAttributeAppList(diseaseId);
        return ResponseViewModel.ok(diseaseAttributeAppList);
    }


}

