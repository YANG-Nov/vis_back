package com.dicadut.soms.controller;

import com.dicadut.soms.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:56:28
 */
@Api(tags = "_智慧运维系统接口")
@Slf4j
@RestController
@RequestMapping("/welcome")
public class SomsController {

    @ApiOperation("测试接口")
    @GetMapping
    public ResponseViewModel<String> getUsrCurrentJobModel() {
        return ResponseViewModel.ok("欢迎使用大连理工大学桥隧智慧运维系统，当前版本 1.0.0");
    }
}
