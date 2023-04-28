package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.DiseaseLocationDTO;

import java.util.List;

public interface DiseaseService  extends IService<Disease> {
    //获取病害位置及严重程度
    List<DiseaseLocationDTO> getDiseaseLocationList(String startTime,String endTime);
}
