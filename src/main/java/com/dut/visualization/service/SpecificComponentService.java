package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.SpecificComponent;
import com.dut.visualization.dto.SpecificComponentInformationDTO;


public interface SpecificComponentService  extends IService<SpecificComponent> {
    SpecificComponentInformationDTO getSpecificComponentInformation(String componentModelCode);
}
