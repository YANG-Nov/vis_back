package com.dicadut.soms.controller;


import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.DieaseDTO;
import com.dicadut.soms.service.DiseaseService;
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
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
@Api(tags = "病害管理接口接口")
@Slf4j
@RestController
@RequestMapping("diease")
public class DiseaseController {


    @Autowired
    private DiseaseService diseaseService;

    @ApiOperation("查询病害")
    @GetMapping("getFrequency")
    public ResponseViewModel<List<DieaseDTO>> getDiease() {
        List<DieaseDTO> dieaseLatestList = diseaseService.getDiseaseList();
        return ResponseViewModel.ok(dieaseLatestList);

    }

}

