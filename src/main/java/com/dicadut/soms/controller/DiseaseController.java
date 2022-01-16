package com.dicadut.soms.controller;


import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.DiseaseAppListDTO;
import com.dicadut.soms.service.DiseaseService;
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
@RequestMapping("diease")
public class DiseaseController {


    @Autowired
    private DiseaseService diseaseService;

    @ApiOperation("查询病害")
    @GetMapping("getFrequency")
    public ResponseViewModel<List<DiseaseAppListDTO>> getDiease() {
        List<DiseaseAppListDTO> dieaseLatestList = diseaseService.getDiseaseList();
        return ResponseViewModel.ok(dieaseLatestList);

    }

    @ApiOperation("App添加病害，不同构件对应的病害列表")
    @GetMapping("getComponentDiseaseAppList")
    public ResponseViewModel<List<DiseaseAppListDTO>> getComponentDiseaseAppList(@RequestParam Integer componentId) {
        List<DiseaseAppListDTO> diseaseAppList = diseaseService.getDiseaseAppList(componentId);
        return ResponseViewModel.ok(diseaseAppList);
    }


}

