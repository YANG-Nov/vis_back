package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.DiseaseLocationDTO;
import com.dut.visualization.dto.DiseaseTypeDTO;

import java.util.List;

public interface DiseaseService  extends IService<Disease> {
    //获取病害位置及严重程度
    List<DiseaseLocationDTO> getDiseaseLocationList(String startTime,String endTime);
    //病害信息页 数据分类统计柱状图
    List<DiseaseTypeDTO> getDiseaseTypeList(String startTime, String endTime);
}
