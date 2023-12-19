package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.SpecificComponent;
import com.dut.visualization.dto.CameraPositionDTO;
import com.dut.visualization.dto.SpecificComponentInformationDTO;
import com.dut.visualization.dto.SpecificTubeDTO;

import java.util.List;


public interface SpecificComponentService  extends IService<SpecificComponent> {
    SpecificComponentInformationDTO getSpecificComponentInformation(String componentModelCode);

    List<SpecificTubeDTO> getSpecificTube();

    CameraPositionDTO getView(String specificComponentId);
}
