package com.dicadut.soms.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.ComponentAppListDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.ComponentPositionAppListDTO;
import com.dicadut.soms.mapper.ComponentMapper;
import com.dicadut.soms.service.ComponentService;
import com.dicadut.soms.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 14:11
 */
@Slf4j
@Service
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, Component> implements ComponentService {

    @Override
    public List<ComponentDTO> getFrequencyList() {

        List<Component> components = baseMapper.selectList(null);
        int value = 0;
        List<ComponentDTO> componentDTOS = new ArrayList<>();
        for (int i = 0; i < components.size(); i++) {
            ComponentDTO componentDTO = new ComponentDTO();
            BeanUtils.copyProperties(components.get(i), componentDTO);
            //componentDTO.setValue(++value);
            componentDTOS.add(componentDTO);
        }

        return componentDTOS;
    }

    /**
     * App添加病害前，选择构件列表（巡检内容）
     *
     * @param taskId 任务id
     * @return 构件列表，树形结构
     */
    //TODO 根据web端进行更改
    @Override
    public List<Tree<Integer>> getComponentAppList(String taskId) {
        List<Component> components = baseMapper.selectComponentAppList(taskId); // 查询所有的桥梁部位
        List<Tree<Integer>> treeList = TreeUtil.convertComponentsToTree(components);
        return treeList;
    }

    @Override
    public List<ComponentPositionAppListDTO> getComponentPositionAppList(String taskId, String componentId) {
        return baseMapper.selectComponentPositionAppList(taskId, componentId);
    }
}
