package com.dicadut.soms.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.domain.Bridge;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-11
 */
public interface BridgeService extends IService<Bridge> {

    List<StakeNumberDTO> getNumberList(String genre, String line);

    List<Tree<Integer>> getComponentList(String start, String end);

    List<StakeNumberDTO> getComponentNumberList(String start, String end, String id);

    List<LineLocationDTO> getLocationList();


}
