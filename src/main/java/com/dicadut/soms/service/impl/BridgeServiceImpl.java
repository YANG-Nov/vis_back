package com.dicadut.soms.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Bridge;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.BridgeSimpleDTO;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
import com.dicadut.soms.mapper.BridgeMapper;
import com.dicadut.soms.service.BridgeService;
import com.dicadut.soms.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-11
 */
@Service
@Slf4j
public class BridgeServiceImpl extends ServiceImpl<BridgeMapper, Bridge> implements BridgeService {

    /**
     * 下拉菜单显示桩号
     */
    @Override
    public List<StakeNumberDTO> getNumberList(String genre, String line) {
        return baseMapper.selectNumberListByGenreLine(genre, line);
    }

    /**
     * 构件树形结构
     *
     * @param start 起始桩号
     * @param end   结束桩号
     * @return
     */
    @Override
    public List<Tree<Integer>> getComponentList(String start, String end) {
        List<Component> components = baseMapper.selectBridgeCompositionList(start, end);    // 查询所有的桥梁部位
        List<Tree<Integer>> treeList = TreeUtil.convertComponentsToTree(components);
        return treeList;
    }

    /**
     * 显示可选择的构建编号
     */
    @Override
    public List<StakeNumberDTO> getComponentNumberList(String start, String end, String id) {
        return baseMapper.selectComponentNumberList(start, end, id);
    }

    @Override
    public List<LineLocationDTO> getLocationList() {
        List<BridgeSimpleDTO> bridgeSimpleDTOList = baseMapper.selectLocationList();
        List<LineLocationDTO> list = new ArrayList<>();

        Map<String, List<StakeNumberDTO>> map = new HashMap<>();   // key: 匝道名, value: 桩号列表（id,name）
        for (BridgeSimpleDTO bridgeSimpleDTO : bridgeSimpleDTOList) {
            String location = bridgeSimpleDTO.getLocation(); // 匝道
            map.putIfAbsent(location, new ArrayList<>());
            StakeNumberDTO stakeNumberDTO = new StakeNumberDTO();
            stakeNumberDTO.setValue(bridgeSimpleDTO.getId());
            stakeNumberDTO.setLabel(bridgeSimpleDTO.getNumber());
            map.get(location).add(stakeNumberDTO);
        }

        for (Map.Entry<String, List<StakeNumberDTO>> entry : map.entrySet()) {
            String location = entry.getKey();
            List<StakeNumberDTO> stakeNumberDTOList = entry.getValue();
            LineLocationDTO lineLocationDTO = new LineLocationDTO();
            lineLocationDTO.setLabel(location);
            lineLocationDTO.setValue(location);
            lineLocationDTO.setChildren(stakeNumberDTOList);
            list.add(lineLocationDTO);
        }

        return list;
    }

}