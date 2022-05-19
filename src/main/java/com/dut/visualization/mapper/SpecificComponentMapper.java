package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.SpecificComponent;
import com.dut.visualization.dto.ComponentInformationDTO;

public interface SpecificComponentMapper extends BaseMapper<SpecificComponent> {
    ComponentInformationDTO selectComponentInformation(String specificComponentId);
}
