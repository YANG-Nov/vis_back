package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.dto.ComponentAppListDTO;
import com.dicadut.soms.domain.Component;

import java.util.List;


/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 14:03
 */
public interface ComponentMapper extends BaseMapper<Component> {

    Integer selectCount();
    List<ComponentAppListDTO> selectComponentAppList(Integer componentId);
}
