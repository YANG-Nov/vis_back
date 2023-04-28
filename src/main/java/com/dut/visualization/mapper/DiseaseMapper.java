package com.dut.visualization.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.DiseaseLocationDTO;

import java.util.List;

public interface DiseaseMapper  extends BaseMapper<Disease> {
    //获取病害位置及严重程度
    List<DiseaseLocationDTO> selectDiseaseLocationList(String startTime,String endTime);
}
