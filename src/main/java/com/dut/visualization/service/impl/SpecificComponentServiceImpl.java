package com.dut.visualization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.SpecificComponent;
import com.dut.visualization.dto.SensorStatusDTO;
import com.dut.visualization.dto.SpecificComponentInformationDTO;
import com.dut.visualization.mapper.SpecificComponentMapper;
import com.dut.visualization.service.SpecificComponentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:09 下午 2022/5/19
 * @ Description：
 * @Version: $
 */
@Slf4j
@Service
public class SpecificComponentServiceImpl extends ServiceImpl<SpecificComponentMapper, SpecificComponent> implements SpecificComponentService {
    @Override
    public SpecificComponentInformationDTO getSpecificComponentInformation(String componentModelCode){
        return baseMapper.selectSpecificComponentInformation(componentModelCode);
    }


}
