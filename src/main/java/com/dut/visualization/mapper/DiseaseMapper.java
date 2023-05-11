package com.dut.visualization.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.DiseaseLocationDTO;
import com.dut.visualization.dto.DiseaseTypeDTO;
import com.dut.visualization.dto.DiseaseZtTimeDTO1;

import java.util.List;

public interface DiseaseMapper  extends BaseMapper<Disease> {
    //获取病害位置及严重程度
    List<DiseaseLocationDTO> selectDiseaseLocationList(String startTime,String endTime);
    //病害信息页 数据分类统计柱状图
    List<DiseaseTypeDTO> selectDiseaseTypeList(String startTime, String endTime);
    //主体结构病害发生时间统计
    List<DiseaseZtTimeDTO1> selectDiseaseZtTimeList(String startTime, String endTime);
}
