package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.Component;
import com.dut.visualization.dto.SpecificComponentInformationDTO;

public interface ComponentMapper extends BaseMapper<Component> {
    SpecificComponentInformationDTO selectComponentInformation(String specificComponentId);
//    ComponentInformationDTO selectComponentInformation(String tunnelId);
}
