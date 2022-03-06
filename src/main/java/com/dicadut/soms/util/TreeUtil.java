package com.dicadut.soms.util;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.TaskBridgeComponentDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2022-02-21 17:33:01
 */
public class TreeUtil extends cn.hutool.core.lang.tree.TreeUtil {

    /**
     * 将components列表转换成树形结构
     *
     * @param components
     * @return
     */
    public static List<Tree<String>> convertComponentsToTree(List<Component> components) {
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();  // 所有树的节点列表，树枝列表
        Set<String> hasAddedIdSet = new HashSet<>();   // 存放已经加入到树的节点，辅助的数据结构

        for (Component component : components) {
            String[] xpathArray = component.getXpath().split("/");
            String[] xnameArray = component.getXname().split("/");
            for (int i = 2; i < xpathArray.length; i++) {   // 遍历xpath中的每一级路径，构造树节点
                String id = xpathArray[i];
                String parentId = xpathArray[i - 1];
                String name = xnameArray[i];
                Integer level = i - 1;
                if (!hasAddedIdSet.contains(id)) {  // 将未加入树中的节点添加到树中
                    TreeNode<String> node = new TreeNode<>(id, parentId, name, level); // weight 存放level值
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
        List<Tree<String>> treeList = build(nodeList, "2001000000", treeNodeConfig,
                (treeNode, tree) -> {
                    String treeId = tree.getId();
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getWeight());
                    tree.setName(treeNode.getName());
                });

        return treeList;
    }

    public static List<Tree<Integer>> convertTaskBridgeComponentsToTree(List<TaskBridgeComponentDTO> taskBridgeComponentDTOS) {
        List<TreeNode<Integer>> nodeList = CollUtil.newArrayList();  // 所有树的节点列表，树枝列表
        Set<Integer> hasAddedIdSet = new HashSet<>();   // 存放已经加入到树的节点，辅助的数据结构

        for (TaskBridgeComponentDTO t : taskBridgeComponentDTOS) {
            String[] xpathArray = t.getXpath().split("/");
            String[] pathArray = TaskUtil.ArraysDelete(xpathArray, 1);
            String[] xpathName = t.getXname().split("/");
            String[] nameArray = TaskUtil.ArraysDelete(xpathName, 1);
            for (int i = 0; i < pathArray.length; i++) {   // 遍历xpath中的每一级路径，构造树节点
                //获得此节点的id和父id
                if (i == 0) {
                    Integer id = Integer.parseInt(pathArray[i]);
                    String name = nameArray[i];
                    Integer level = i;
                    TreeNode<Integer> node = new TreeNode<>(id, 0, name, level);
                    if (!hasAddedIdSet.contains(id)) {  // 将未加入树中的节点添加到树中
                        // weight 存放level值
                        nodeList.add(node);
                        hasAddedIdSet.add(id);

                    }
                    continue;
                }
                Integer id = Integer.parseInt(pathArray[i]);
                Integer parentId = Integer.parseInt(pathArray[i - 1]);
                String name = nameArray[i];
                Integer level = i;
                TreeNode<Integer> node = new TreeNode<>(id, parentId, name, level); // weight 存放level值
                if (!hasAddedIdSet.contains(id)) {  // 将未加入树中的节点添加到树中
                    nodeList.add(node);
                    hasAddedIdSet.add(id);
                }

            }
        }
        List<Tree<Integer>> treeList = cn.hutool.core.lang.tree.TreeUtil.build(nodeList);    // 指定根节点，创建构件树
        return treeList;
    }
}
