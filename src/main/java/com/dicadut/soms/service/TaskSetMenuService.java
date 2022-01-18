package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.domain.TaskSetMenu;

import java.util.List;


/**
 * <p>
 * 任务套餐表 服务类
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-17
 */
public interface TaskSetMenuService extends IService<TaskSetMenu> {
    void saveTaskMenu( List<ComponentDTO> componentDTOList);
}
