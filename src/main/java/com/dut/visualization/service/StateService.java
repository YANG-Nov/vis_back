package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.State;
import com.dut.visualization.dto.StateInputDTO;


public interface StateService extends IService<State> {

    void addState(StateInputDTO stateInputDTO);

    StateInputDTO getState(String tube);
}
