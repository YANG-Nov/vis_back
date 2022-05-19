package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.SpecificComponent;
import com.dut.visualization.dto.ComponentInformationDTO;


public interface SpecificComponentService  extends IService<SpecificComponent> {
    ComponentInformationDTO getComponentInformation(String specificComponentId);
}
