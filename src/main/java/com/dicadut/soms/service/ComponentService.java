package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.ComponentAppListDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.ComponentPositionAppListDTO;


import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 14:00
 */
public interface ComponentService extends IService<Component> {
    List<ComponentDTO> getFrequencyList();

    /**
     * App添加病害前，选择构件列表
     * @param componentId 一级构件id
     * @return 构件列表
     */
    List<ComponentAppListDTO> getComponentAppList(Integer componentId);

    /**
     * APP添加病害页面，选择构件位置
     * @param taskId 任务id
     * @param componentId 构件id
     * @return  构件位置
     */
    List<ComponentPositionAppListDTO> getComponentPositionAppList(String taskId, String componentId);
}
