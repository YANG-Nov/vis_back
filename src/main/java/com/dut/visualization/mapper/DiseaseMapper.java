package com.dut.visualization.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.*;

import java.util.List;

public interface DiseaseMapper  extends BaseMapper<Disease> {
    //获取病害位置及严重程度
    List<DiseaseLocationDTO> selectDiseaseLocationList(String startTime,String endTime);
    //查询主体、接头、附属分别有哪些病害类型
    List<DiseaseTypeDTO> selectDiseaseTypeList(String diseaseTypeId);
    //病害信息页 病害部位-数量统计（主体、接头、附属）
    List<DiseasePlaceNumDTO> selectDiseasePlaceNumList(String startTime, String endTime);
    //主体结构病害发生时间统计
    List<DiseaseZtTimeDTO1> selectDiseaseZtTimeList(String startTime, String endTime);
    //病害信息页 病害类型-数量统计
    List<DiseaseTypeNumDTO> selectDiseaseTypeNumList(String diseaseParentId,String startTime,String endTime);
    //病害发生位置-数量统计图
    List<DiseasePositionNumDTO> selectDiseasePositionNum(String startTime, String endTime);
    //病害严重程度-数量统计
    List<DiseaseDegreeNumDTO> selectDiseaseDegreeNum(String startTime, String endTime);
    //通过Code和Repair筛选出的结果
    List<DiseaseSelectByCodeAndRepair> selectByCodeAndRepair(String startTime, String endTime, String diseaseId);
}
