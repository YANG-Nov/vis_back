package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.domain.TaskSetMenu;
import com.dicadut.soms.mapper.TaskSetMenuMapper;
import com.dicadut.soms.service.TaskSetMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务套餐表 服务实现类
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-17
 */
@Service
@Slf4j
public class TaskSetMenuServiceImpl extends ServiceImpl<TaskSetMenuMapper, TaskSetMenu> implements TaskSetMenuService {
    /**
     *点提交，保存套餐
     * 第一步：在套餐表里创建新的一行数据，并根据上一行的数据判断所起的名字
     *          1.获取tasksetmenu表里的id
     *          2.判断里面id是多少。
     *          3.根据id拼接名字
     *          4.插入表中
     * 第二步：在构件关联表中加入数据
     * TODO 后面再完善
     */
    @Override
    public void saveTaskMenu(List<ComponentDTO> componentDTOList) {
        QueryWrapper<TaskSetMenu> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.orderByDesc("id").last("limit 1");
        TaskSetMenu taskSetMenu = baseMapper.selectOne(objectQueryWrapper);

        if (taskSetMenu == null){
            String menuName="组合1";//TODO 后面再完善
            baseMapper.insertMenu(menuName);
            baseMapper.insertMenuComponent("1",componentDTOList);
        }else{
            String menuName="组合" + (taskSetMenu.getId()+1);//TODO 后面再完善
            baseMapper.insertMenu(menuName);
            baseMapper.insertMenuComponent((taskSetMenu.getId()+1)+" ",componentDTOList);
        }




    }
}
