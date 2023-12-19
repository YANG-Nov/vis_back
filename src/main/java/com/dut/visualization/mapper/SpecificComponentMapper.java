package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.SpecificComponent;
import com.dut.visualization.dto.CameraPositionDTO;
import com.dut.visualization.dto.SpecificComponentInformationDTO;
import com.dut.visualization.dto.SpecificTubeDTO;

import java.util.List;

public interface SpecificComponentMapper extends BaseMapper<SpecificComponent> {
    SpecificComponentInformationDTO selectSpecificComponentInformation(String componentModelCode);
    List<SpecificTubeDTO> selectSpecificTube();

    CameraPositionDTO selectView(String specificComponentId);
}
