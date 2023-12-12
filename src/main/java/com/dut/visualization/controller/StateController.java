package com.dut.visualization.controller;

import com.dut.visualization.domain.State;
import com.dut.visualization.dto.DiseaseNumDTO;
import com.dut.visualization.dto.StateInputDTO;
import com.dut.visualization.service.StateService;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:21 下午 2023/12/6
 * @ Description：隧道服役状态评估接口
 * @Version: 1.0.0$
 */
@Api(tags = "隧道服役状态评估接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/state")
public class StateController {
    @Resource
    private StateService stateService;

    @ApiOperation(value = "保存隧道服役状态评估指标", tags = {"状态推演", "未通"})
    @PostMapping("/post_state")
    public ResponseViewModel postState(@RequestBody StateInputDTO stateInputDTO) {
        System.out.println(stateInputDTO);
        stateService.addState(stateInputDTO);
        return ResponseViewModel.ok();
    }

    @ApiOperation(value = "隧道服役状态评估指标返显", tags = {"状态推演", "未通"})
    @GetMapping("/get_state/{tube}")
    public ResponseViewModel<StateInputDTO> getState(@PathVariable String tube) {
        StateInputDTO stateInputDTOs = stateService.getState(tube);
        return ResponseViewModel.ok(stateInputDTOs);
    }
}
