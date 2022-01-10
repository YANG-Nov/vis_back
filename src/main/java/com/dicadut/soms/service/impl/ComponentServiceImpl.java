package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.entity.Component;
import com.dicadut.soms.mapper.ComponentMapper;
import com.dicadut.soms.service.ComponentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            componentDTO.setValue(++value);
            componentDTOS.add(componentDTO);
        }

        return componentDTOS;
    }
}
