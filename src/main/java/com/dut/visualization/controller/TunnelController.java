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
@RequestMapping("/api/tunnel")
public class TunnelController {


    @Resource
    private TunnelService tunnelService;

    /**
     * 根据项目id查看项目基本信息
     * @param tunnelId 项目id
     * @return 项目基本信息
     */
    @ApiOperation(value = "根据项目id查看项目基本信息", tags = {"首页","已通"})
    @GetMapping("/get_tunnel_basic_information/{tunnelId}")
    public ResponseViewModel<TunnelBasicInformationDTO> getTunnelBasicInformation(@PathVariable String tunnelId) {
        TunnelBasicInformationDTO tunnelBasicInformationDTO = tunnelService.getTunnelBasicInformation(tunnelId);
        return ResponseViewModel.ok(tunnelBasicInformationDTO);
    }
}

