package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.mapper.ComponentMapper;
import com.dicadut.soms.service.ComponentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 14:11
 */
@Slf4j
@Service
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, Component> implements ComponentService {

    @Override
    @Deprecated
    public List<ComponentDTO> getFrequencyList() {

        List<Component> components = baseMapper.selectList(null);
        List<ComponentDTO> componentDTOS = new ArrayList<>();
        for (Component component : components) {
            ComponentDTO componentDTO = new ComponentDTO();
            BeanUtils.copyProperties(component, componentDTO);
            //componentDTO.setValue(++value);
            componentDTOS.add(componentDTO);
        }

        return componentDTOS;
    }

    /**
     * App添加病害前，选择构件列表（巡检内容）
     *
     * @param taskId 任务id
     * @return 任务所包含的构件列表，带导航栏
     */
    @Override
    public List<TaskComponentAppDTO> getComponentAppList(String taskId) {
        //从数据库中查出数据
        List<ComponentAppListDTO> components = baseMapper.selectComponentAppList(taskId); // 查询所有的桥梁部位
        //返回数据集合
        List<TaskComponentAppDTO> list = new ArrayList<>();
        //过渡map集合，key: eg:东引桥B匝道桥面系, value: componentId、component
        Map<String, List<TaskComponentAppDTO.Item>> map = new HashMap<>();
        //遍历数据库中封装一次查到的数据对象集合
        for (ComponentAppListDTO componentAppListDTO : components){
            //添加key：eg:东引桥B匝道桥面系
            String location = componentAppListDTO.getLocation();
            String parentComponent = componentAppListDTO.getParentComponent();
            String inspectionLocation = location+parentComponent;
            map.putIfAbsent(inspectionLocation,new ArrayList<>());
            //添加value：componentId、component
            TaskComponentAppDTO.Item of = new TaskComponentAppDTO.Item();
            of.setComponentId(componentAppListDTO.getComponentId());
            of.setComponent(componentAppListDTO.getComponent());
            map.get(inspectionLocation).add(of);
        }
        //遍历map集合
        for (Map.Entry<String,List<TaskComponentAppDTO.Item>> entry : map.entrySet()){
            //取得key和value
            String inspectionLocation = entry.getKey();
            List<TaskComponentAppDTO.Item> items = entry.getValue();
            //赋值给需要返回的集合
            TaskComponentAppDTO taskComponentAppDTO = new TaskComponentAppDTO();
            taskComponentAppDTO.setInspectionLocation(inspectionLocation);
            taskComponentAppDTO.setComponentList(items);
            list.add(taskComponentAppDTO);
        }
        return list;
    }

    /**
     * APP添加病害页面，选择构件位置
     * @param taskId 任务id
     * @param componentId 构件id
     * @return  构件所对应的桩号列表
     */
    @Override
    public List<ComponentPositionAppListDTO> getComponentPositionAppList(String taskId, String componentId) {
        return baseMapper.selectComponentPositionAppList(taskId, componentId);
    }
}
