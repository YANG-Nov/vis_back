package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.ComponentAppListDTO;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.domain.Component;


import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 14:00
 */
public interface ComponentService extends IService<Component> {
    List<ComponentDTO> getFrequencyList();

    List<ComponentAppListDTO> getComponentAppList(Integer componentId);
}
