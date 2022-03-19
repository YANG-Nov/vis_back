package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.domain.Component;
import com.dicadut.soms.dto.ComponentNumberAppListDTO;
import com.dicadut.soms.dto.ComponentPositionAppListDTO;
import com.dicadut.soms.dto.TaskComponentAppDTO;


import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 14:00
 */
public interface ComponentService extends IService<Component> {
    List<ComponentDTO> getFrequencyList();

    /**
     * App添加病害前，选择构件列表（巡检内容）
     * @param taskId 任务id
     * @return 任务所包含的构件列表，带导航栏
     */
    List<TaskComponentAppDTO> getComponentAppList(String taskId);

    /**
     * APP添加病害页面，选择构件位置
     * @param taskId 任务id
     * @param componentId 构件id
     * @return  构件所对应的桩号列表
     */
    List<ComponentPositionAppListDTO> getComponentPositionAppList(String taskId, String componentId);

    /**
     * APP添加病害页面，选择构件编号
     * @param componentId 构件id
     * @param positionId 位置id
     * @return 构件所对应的该桩号下的构件编号
     */
    List<ComponentNumberAppListDTO> getComponentNumberAppList(String componentId, String positionId);
}
