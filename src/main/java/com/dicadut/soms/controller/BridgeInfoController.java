package com.dicadut.soms.controller;


import com.dicadut.soms.viewmodel.ResponseViewModel;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
import com.dicadut.soms.service.BridgeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-11
 */
@Api(tags = "桥梁信息接口")
@Slf4j
@RestController
@RequestMapping("/bridge")
public class BridgeInfoController {
    //访问地址 ：http://localhost:8089/bridge
    //注入service
    @Autowired
    private BridgeInfoService bridgeInfoService;
    /**
     *暂时不用了
     *
     * @author fan_jane
     */
//    @ApiOperation("制定任务页桩号下拉框：东引桥A匝道 1 1，东引桥B匝道 1 2，东引桥S匝道 1 3，东引桥X匝道 1 4，主桥 2 5， " +
//            "西引桥S匝道 3 3， 西引桥X匝道 3 4 ")
//    @GetMapping("/getStakeOrTrussNumber/{genre}/{line}")
//    public ResponseViewModel<List<StakeNumberDTO>> getNumberList(@PathVariable String genre, @PathVariable String line) {
//        return ResponseViewModel.ok(bridgeInfoService.getNumberList(genre,line));
//    }
    /**
     *
     *
     * @author fan_jane
     */
    @ApiOperation("制定任务页根据桩号显示构件:B0-B16 12000-12016 ")
    @GetMapping("/getComponentNumber/{start}/{end}")
    public ResponseViewModel<List<ComponentDTO>> getComponentList(@PathVariable String start, @PathVariable String end) {
        return ResponseViewModel.ok(bridgeInfoService.getComponentList(start,end));
    }
    /**
     *
     *
     * @author fan_jane
     */
    @ApiOperation("制定任务页根据桩号显示可选择的构件编号:B0-B16 12000-12016,桥面铺装 2001000012 桥头平顺2001000013，  伸缩缝2001000014， 排水口2001000015， 排水管2001000016， 栏杆2001000017， 防撞护栏2001000018， 人行道 2001000019")
    @GetMapping("/getComponentNumber/{start}/{end}/{id}")
    public ResponseViewModel<List<StakeNumberDTO>> getComponentNumberList(@PathVariable String start, @PathVariable String end,@PathVariable String id) {
        return ResponseViewModel.ok(bridgeInfoService.getComponentNumberList(start,end,id));
    }

    /**
     *
     *
     * @author fan_jane
     */
    @ApiOperation("任务制定-添加任务页显示下拉菜单框前面内容和桩号")
    @GetMapping("/showLocation")
    public ResponseViewModel<List<LineLocationDTO>> getLocationList() {
        return ResponseViewModel.ok(bridgeInfoService.getLocationList());
    }
}

