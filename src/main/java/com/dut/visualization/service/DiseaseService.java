package com.dut.visualization.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.*;

import java.util.List;

public interface DiseaseService  extends IService<Disease> {
    //获取病害位置及严重程度
    List<DiseaseLocationDTO> getDiseaseLocationList(String startTime,String endTime);
    //查询主体、接头、附属分别有哪些病害类型
    List<DiseaseTypeDTO> getDiseaseTypeList(String diseaseTypeId);
    //病害信息页 病害部位-数量统计（主体、接头、附属）
    List<DiseasePlaceNumDTO> getDiseasePlaceNumList(String startTime, String endTime);
    //主体结构病害发生时间统计
    List<DiseaseZtTimeDTO> getDiseaseZtTimeList(String startTime, String endTime);
    //病害信息页 病害类型-数量统计
    List<DiseaseTypeNumDTO> getDiseaseTypeNumList(String diseaseParentId,String startTime,String endTime);
    //病害发生位置-数量统计
    List<DiseasePositionNumDTO> getDiseasePositionNum(String startTime, String endTime);
    //病害严重程度-数量统计
    List<DiseaseDegreeNumDTO> getDiseaseDegreeNum(String startTime, String endTime);
    //病害发生时间-数量统计
    List<DiseaseTimeNumDTO> getDiseaseTimeNum(String startTime, String endTime, String diseaseId);
    //单个病害详情（病害历史）
    List<DiseaseInfoHistoryDTO> getDiseaseInfoHistory(String modelCode);
}
