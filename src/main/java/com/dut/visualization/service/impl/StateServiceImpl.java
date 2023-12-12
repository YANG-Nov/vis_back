package com.dut.visualization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.State;
import com.dut.visualization.dto.StateInputDTO;
import com.dut.visualization.mapper.StateMapper;
import com.dut.visualization.service.StateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:23 下午 2023/12/6
 * @ Description：隧道服役状态评估接口
 * @Version: 1.0.0$
 */
@Slf4j
@Service
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements StateService {
    @Override
    public void addState(StateInputDTO stateInputDTO) {
        if (stateInputDTO == null){
            return;
        }
        baseMapper.insertState(stateInputDTO);
    }
    @Override
    public StateInputDTO getState(String tube){
        return baseMapper.selectState(tube);
    }
}
