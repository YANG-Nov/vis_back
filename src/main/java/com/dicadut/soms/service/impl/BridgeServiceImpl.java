package com.dicadut.soms.service.impl;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Bridge;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.BridgeSimpleDTO;
import com.dicadut.soms.dto.ComponentNumberDTO;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
import com.dicadut.soms.mapper.BridgeMapper;
import com.dicadut.soms.service.BridgeService;
import com.dicadut.soms.util.TaskUtil;
import com.dicadut.soms.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
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
    @Deprecated
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
    public List<Tree<String>> getComponentList(String start, String end) {
        List<Component> components = baseMapper.selectBridgeCompositionList(start, end);    // 查询所有的桥梁部位
        List<Tree<String>> treeList = TreeUtil.convertComponentsToTree(components);
        return treeList;
    }

    /**
     * 显示可选择的构建编号
     */
    @Override
    @Deprecated
    public List<ComponentNumberDTO> getComponentNumberList(String start, String end, String id) {
        return baseMapper.selectComponentNumberList(start, end, id);
    }

    @Override
    public List<LineLocationDTO> getLocationList() {
        //一次查询数据库，将所有用到的数据封装到一级过渡对象当中
        List<BridgeSimpleDTO> bridgeSimpleDTOList = baseMapper.selectLocationList();

        //返回数据集合
        List<LineLocationDTO> list = new ArrayList<>();

        // 过渡map集合，key: 主引桥+匝道（location）, value: 桩号对象列表（id,name）
        Map<String, List<StakeNumberDTO>> map = new HashMap<>();

        //遍历数据库中封装一次查到的数据对象集合
        for (BridgeSimpleDTO bridgeSimpleDTO : bridgeSimpleDTOList) {
            //添加key: 主引桥+匝道（location）
            String location = bridgeSimpleDTO.getLocation();
            map.putIfAbsent(location, new ArrayList<>());

            //添加value：value: 桩号对象（id,name）
            StakeNumberDTO stakeNumberDTO = new StakeNumberDTO();
            stakeNumberDTO.setValue(bridgeSimpleDTO.getId());
            stakeNumberDTO.setLabel(bridgeSimpleDTO.getNumber());
            map.get(location).add(stakeNumberDTO);
        }

        //遍历map集合
        for (Map.Entry<String, List<StakeNumberDTO>> entry : map.entrySet()) {
            //取得key和value
            String location = entry.getKey();
            List<StakeNumberDTO> stakeNumberDTOList = entry.getValue();

            //赋值给需要返回的集合
            LineLocationDTO lineLocationDTO = new LineLocationDTO();
            lineLocationDTO.setLabel(location);
            lineLocationDTO.setValue(location);
            lineLocationDTO.setChildren(stakeNumberDTOList);
            list.add(lineLocationDTO);
        }

        return list;
    }

    /**
     * 测试公共代码
     *
     * @return
     */
    @Override
    public List<LineLocationDTO> getLocationListTest() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //一次查询数据库，将所有用到的数据封装到一级过渡对象当中
        List<BridgeSimpleDTO> bridgeSimpleDTOList = baseMapper.selectLocationList();


        List<LineLocationDTO> list = TaskUtil.convert(bridgeSimpleDTOList, LineLocationDTO.class, BridgeSimpleDTO.class,"location","label");

        return list;

    }
}