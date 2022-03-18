package com.dicadut.soms.controller;


import com.dicadut.soms.dto.TypeNameDTO;
import com.dicadut.soms.service.DictionaryService;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-01-03
 */
@Api(tags = "字典接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/dictionary")
public class DictionaryController {

    @Resource
    private DictionaryService dictionaryService;

    /**
     *
     * 根据任务类型或构件频率id从字典中返回可选择的任务类型或构件频率列表
     *
     * @param type 任务类型或构件频率id
     * @return 任务类型或构件频率列表
     * @author fan_jane
     */
    @ApiOperation(value = "制定任务页显示任务类型和构件频率", tags = {"web", "任务制定页","jane","已通"}
            , notes = "任务类型type:1001,构件频率type:2004")
    @GetMapping("/get_type_names/{type}")
    public ResponseViewModel<List<TypeNameDTO>> getTypeNames(@PathVariable String type) {
        return ResponseViewModel.ok(dictionaryService.getTypeNames(type));
    }


}

