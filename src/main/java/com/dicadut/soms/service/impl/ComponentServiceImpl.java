package com.dicadut.soms.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.ComponentAppListDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.ComponentPositionAppListDTO;
import com.dicadut.soms.mapper.ComponentMapper;
import com.dicadut.soms.service.ComponentService;
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
     * @param taskId 任务id
     * @return 构件列表，树形结构
     */
    @Override
    public List<Tree<Integer>> getComponentAppList(String taskId) {
        //查询所有的桥梁部位
        List<Component> componentAppDTOS = baseMapper.selectComponentAppList(taskId);
        List<TreeNode<Integer>> nodeList = CollUtil.newArrayList();  // 所有树的节点列表，树枝列表
        Set<Integer> hasAddedIdSet = new HashSet<>();   // 存放已经加入到树的节点，辅助的数据结构

        for (Component component : componentAppDTOS) {
            String[] xpathArray = component.getXpath().split("/");
            String[] xnameArray = component.getXname().split("/");
            for (int i = 2; i < xpathArray.length; i++) {   // 遍历xpath中的每一级路径，构造树节点
                Integer id = Integer.parseInt(xpathArray[i]);
                Integer parentId = Integer.parseInt(xpathArray[i - 1]);
                String name = xnameArray[i];
                Integer level = i - 1;
                if (!hasAddedIdSet.contains(id)) {  // 将未加入树中的节点添加到树中
                    TreeNode<Integer> node = new TreeNode<>(id, parentId, name, level); // weight 存放level值
                    nodeList.add(node);
                    hasAddedIdSet.add(id);
                }
            }
        }

        // 适配前端组件
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都要默认值的
        treeNodeConfig.setWeightKey("level");
        treeNodeConfig.setIdKey("value");
        treeNodeConfig.setParentIdKey("parentValue");
        treeNodeConfig.setNameKey("label");
        //转换器
        List<Tree<Integer>> treeList = TreeUtil.build(nodeList, 2001000000, treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getWeight());
                    tree.setName(treeNode.getName());
                });

        return treeList;
    }

    @Override
    public List<ComponentPositionAppListDTO> getComponentPositionAppList(String taskId, String componentId) {
        return baseMapper.selectComponentPositionAppList(taskId,componentId);
    }
}
