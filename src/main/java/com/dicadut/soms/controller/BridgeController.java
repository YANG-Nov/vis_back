package com.dicadut.soms.controller;


import cn.hutool.core.lang.tree.Tree;
import com.dicadut.soms.dto.ComponentNumberDTO;
import com.dicadut.soms.dto.LineLocationVO;
import com.dicadut.soms.service.BridgeService;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fan_jane
 * @version 1.0
 * @since 2022-01-11
 */
@Api(tags = "桥梁接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/bridge")
public class BridgeController {

    @Resource
    private BridgeService bridgeService;

    /**
     * 根据桩号返回可选择的构件列表，构件有层级结构
     *
     * @param start 起始桩号id
     * @param end   结束桩号id
     * @return 带层级结构的构件列表
     * @author fan_jane
     */
    @ApiOperation(value = "制定任务页显示构件", tags = {"web", "任务制定页", "jane", "已通"}
            , notes = "传入id:B0-B16 起始桩号id12000，终止桩号id12016")
    @GetMapping("/get_component_number/{start}/{end}")
    public ResponseViewModel<List<Tree<String>>> getComponentList(@PathVariable String start, @PathVariable String end) {
        return ResponseViewModel.ok(bridgeService.getComponentList(start, end));
    }

    /**
     * Jane_TODO 2022/2/24 后期再改成requestbody
     * 根据桩号和构件id返回可选择的构件编号列表
     *
     * @param start 起始桩号id
     * @param end   结束桩号id
     * @param id    构件id
     * @return 构件编号列表
     * @author fan_jane
     */
    @ApiOperation(value = "制定任务页根据桩号显示可选择的构件编号", tags = {"web", "任务制定页", "jane"}
            , notes = "B0-B16 12000-12016,桥面铺装2001000012桥头平顺2001000013伸缩缝2001000014排水口2001000015" +
            "排水管2001000016栏杆2001000017防撞护栏2001000018人行道 200100001")
    @GetMapping("/get_component_number/{start}/{end}/{id}")
    @Deprecated
    public ResponseViewModel<List<ComponentNumberDTO>> getComponentNumberList(@PathVariable String start
            , @PathVariable String end, @PathVariable String id) {
        return ResponseViewModel.ok(bridgeService.getComponentNumberList(start, end, id));
    }

    /**
     * 桩号选择下拉框接口的
     * 使用场景: 创建任务时，桩号选择下来框用到该接口（开始桩号及结束桩号都要调用该接口）
     * 输入参数：无
     * Jane_TODO 2022/3/17 /get_inspection_scope
     *
     * @return 带层级结构的桩号列表数据，第一级是匝道(location)，第二级是桩号(id,number)
     * SQL: select b.id, b.stake_or_truss_number, b.location from t_bridge b;
     * @author fan_jane
     */
    @ApiOperation(value = "制定任务页显示巡检范围", tags = {"web", "任务制定页", "jane", "已通"})
    @GetMapping("/show_location")
    public ResponseViewModel<List<LineLocationVO>> getLocationList() {
        return ResponseViewModel.ok(bridgeService.getLocationList());
    }

    /**
     * 测试
     *
     * @return
     * @throws NoSuchFieldException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @ApiOperation(value = "制定任务页显示桩号选择下拉框", tags = {"web", "任务制定页", "jane", "测试"})
    @GetMapping("/show_location_test")
    @Deprecated
    public ResponseViewModel<List<LineLocationVO>> getLocationListTest() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return ResponseViewModel.ok(bridgeService.getLocationListTest());
    }
}

