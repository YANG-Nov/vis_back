package com.dut.visualization.controller;

import com.dut.visualization.dto.TunnelBasicInformationDTO;
import com.dut.visualization.service.TunnelService;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
@Api(tags = "隧道基本信息接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("disease")
public class TunnelController {


    @Resource
    private TunnelService tunnelService;

    @ApiOperation(value = "getTunnelBasicInformation", tags = {"首页","未通"})
    @GetMapping("get_tunnel_basic_information")
    public ResponseViewModel<TunnelBasicInformationDTO> getTunnelBasicInformation(@RequestParam String tunnelId) {
        TunnelBasicInformationDTO tunnelBasicInformationDTO = tunnelService.getTunnelBasicInformation(tunnelId);
        return ResponseViewModel.ok(tunnelBasicInformationDTO);
    }
}

