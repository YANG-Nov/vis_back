package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.BridgeCompositionDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
import com.dicadut.soms.entity.BridgeInfo;
import com.dicadut.soms.mapper.BridgeInfoMapper;
import com.dicadut.soms.service.BridgeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
public class BridgeInfoServiceImpl extends ServiceImpl<BridgeInfoMapper, BridgeInfo> implements BridgeInfoService {

    /**
     *
     * 下拉菜单显示桩号
     */
    @Override
    public List<StakeNumberDTO> getNumberList(String genre, String line) {
        return baseMapper.selectNumberListByGenreLine(genre,line);
    }
    /**
     *显示可选择的构建
     * 第一步获取桥梁部位封装数据
     * 第二部获取构件部位封装数据
     */
    @Override
    public List<ComponentDTO> getComponentList(String start, String end) {
        //查询所有的桥梁部位
        List<BridgeCompositionDTO> bridgeCompositionDTOS = baseMapper.selectBridgeCompositionList(start, end);
        //查询该部位含有的构件
        List<ComponentDTO> componentDTOS = new ArrayList<>();
        for (BridgeCompositionDTO b:
                bridgeCompositionDTOS) {
            componentDTOS = baseMapper.selectComponentByBridgeComposition(start,end,b.getId());
        }

        return componentDTOS;
    }
    /**
     *显示可选择的构建编号
     *
     */
    @Override
    public List<StakeNumberDTO> getComponentNumberList(String start, String end, String id) {
        return baseMapper.selectComponentNumberList(start,end,id);
    }

    @Override
    public List<LineLocationDTO> getLocationList() {
        List<LineLocationDTO> lineLocationDTOS = baseMapper.selectLocationList();
        for (LineLocationDTO lineLocationDTO:lineLocationDTOS
             ) {
            lineLocationDTO.setStakeNumberDTOS(baseMapper.selectNumberListByGenreLine(lineLocationDTO.getGenreId(),lineLocationDTO.getGenreId()));
            
        }
        return lineLocationDTOS;
    }

}