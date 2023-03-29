package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.Component;
import com.dut.visualization.dto.SpecificComponentInformationDTO;


public interface ComponentService extends IService<Component> {

    SpecificComponentInformationDTO getComponentInformation(String componentCode);
}
