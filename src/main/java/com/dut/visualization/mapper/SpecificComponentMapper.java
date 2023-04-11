package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.SpecificComponent;
import com.dut.visualization.dto.SpecificComponentInformationDTO;

public interface SpecificComponentMapper extends BaseMapper<SpecificComponent> {
    SpecificComponentInformationDTO selectSpecificComponentInformation(String componentModelCode);
}
