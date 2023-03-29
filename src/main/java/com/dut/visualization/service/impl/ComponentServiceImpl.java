package com.dut.visualization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.Component;
import com.dut.visualization.dto.SpecificComponentInformationDTO;
import com.dut.visualization.mapper.ComponentMapper;
import com.dut.visualization.service.ComponentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:44 下午 2022/5/19
 * @ Description：
 * @Version: $
 */
@Slf4j
@Service
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, Component> implements ComponentService {
    @Override
    public SpecificComponentInformationDTO getComponentInformation(String specificComponentId){
        return baseMapper.selectComponentInformation(specificComponentId);
    }
}
