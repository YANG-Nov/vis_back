package com.dut.visualization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.State;
import com.dut.visualization.dto.StateInputDTO;
import com.dut.visualization.dto.StateInputIdMaxDTO;

public interface StateMapper extends BaseMapper<State> {
    StateInputIdMaxDTO selectStateInputIdMax();
    void insertState(StateInputDTO stateInputDTO);

    StateInputDTO selectState(String tube);
}
