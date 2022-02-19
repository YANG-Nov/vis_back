package com.dicadut.soms.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Bridge;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.BridgeSimpleDTO;
import com.dicadut.soms.dto.LineLocationDTO;
import com.dicadut.soms.dto.StakeNumberDTO;
import com.dicadut.soms.mapper.BridgeMapper;
import com.dicadut.soms.service.BridgeService;
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
        //查询所有的桥梁部位
        List<Component> bridgeCompositionDTOS = baseMapper.selectBridgeCompositionList(start, end);
        List<TreeNode<Integer>> nodeList = CollUtil.newArrayList();
        Set<Integer> hasAddedIdSet = new HashSet<>();   // 存放已经加入到树的节点
        for (Component component : bridgeCompositionDTOS) {
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
        treeNodeConfig.setNameKey("label");
        // 最大递归深度
        treeNodeConfig.setDeep(30);
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