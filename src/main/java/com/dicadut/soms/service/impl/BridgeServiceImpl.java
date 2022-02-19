package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.BridgeCompositionDTO;
import com.dicadut.soms.dto.BridgeSimpleDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
import com.dicadut.soms.domain.Bridge;
import com.dicadut.soms.mapper.BridgeMapper;
import com.dicadut.soms.service.BridgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 显示可选择的构建
     * 第一步获取桥梁部位封装数据
     * 第二部获取构件部位封装数据
     */
    @Override
    public List<ComponentDTO> getComponentList(String start, String end) {
        //查询所有的桥梁部位
        List<BridgeCompositionDTO> bridgeCompositionDTOS = baseMapper.selectBridgeCompositionList(start, end);
        //查询该部位含有的构件
        List<ComponentDTO> componentDTOS = new ArrayList<>();
        for (BridgeCompositionDTO b : bridgeCompositionDTOS) {
            componentDTOS = baseMapper.selectComponentByBridgeComposition(start, end, b.getId());
        }

        return componentDTOS;
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
            stakeNumberDTO.setId(bridgeSimpleDTO.getId());
            stakeNumberDTO.setNumber(bridgeSimpleDTO.getNumber());
            map.get(location).add(stakeNumberDTO);
        }

        for (Map.Entry<String, List<StakeNumberDTO>> entry : map.entrySet()) {
            String location = entry.getKey();
            List<StakeNumberDTO> stakeNumberDTOList = entry.getValue();
            LineLocationDTO lineLocationDTO = new LineLocationDTO();
            lineLocationDTO.setLocation(location);
            lineLocationDTO.setStakeNumberDTOS(stakeNumberDTOList);
            list.add(lineLocationDTO);
        }

        return list;
    }

}