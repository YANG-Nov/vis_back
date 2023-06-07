package com.dut.visualization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.*;
import com.dut.visualization.mapper.DiseaseMapper;
import com.dut.visualization.service.DiseaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 10:30 上午 2023/4/27
 * @ Description：病害信息实现类
 * @Version: 1.0.0$
 */
@Slf4j
@Service
public class DiseaseServiceImpl   extends ServiceImpl<DiseaseMapper, Disease> implements DiseaseService {
    //获取病害位置及严重程度
    @Override
    public List<DiseaseLocationDTO> getDiseaseLocationList(String startTime,String endTime){
        return baseMapper.selectDiseaseLocationList(startTime,endTime);
    }

    //病害信息页 病害部位-数量统计（主体、接头、附属）
    @Override
    public List<DiseasePlaceNumDTO> getDiseasePlaceNumList(String startTime, String endTime){
        return baseMapper.selectDiseasePlaceNumList(startTime,endTime);
    }

    //主体结构病害发生时间统计
    @Override
    public List<DiseaseZtTimeDTO> getDiseaseZtTimeList(String startTime, String endTime){
        List<DiseaseZtTimeDTO1> list = baseMapper.selectDiseaseZtTimeList(startTime, endTime);
        List<DiseaseZtTimeDTO> list1 = new ArrayList<>();
        int value = 0;
        for (DiseaseZtTimeDTO1 diseaseZtTimeDTO1 : list) {
            DiseaseZtTimeDTO diseaseZtTimeDTO = new DiseaseZtTimeDTO();
            if(diseaseZtTimeDTO1.getIsRepair() == 0){
                diseaseZtTimeDTO.setValue(++ value);
                diseaseZtTimeDTO.setCreateTime(diseaseZtTimeDTO1.getCreateTime());
                list1.add(diseaseZtTimeDTO);
                //todo 需要判断disease_code在已循环完的数据中是否有重复,
                // 有重复的话，value值不变；无重复的话，value值+1
            }if(diseaseZtTimeDTO1.getIsRepair() == 1){
                diseaseZtTimeDTO.setValue(-- value);
                diseaseZtTimeDTO.setCreateTime(diseaseZtTimeDTO1.getCreateTime());
                list1.add(diseaseZtTimeDTO);
            }
        }
        return list1;
    }
    //查询主体、接头、附属分别有哪些病害类型
    public List<DiseaseTypeDTO> getDiseaseTypeList(String diseaseTypeId) {
        return baseMapper.selectDiseaseTypeList(diseaseTypeId);
    }
    //病害信息页 病害类型-数量统计
    public List<DiseaseTypeNumDTO> getDiseaseTypeNumList(String diseaseParentId,String startTime,String endTime) {
        return baseMapper.selectDiseaseTypeNumList(diseaseParentId,startTime,endTime);
    }
    //病害信息页 病害位置-数量统计
    @Override
    public List<DiseasePositionNumDTO> getDiseasePositionNum(String startTime, String endTime){
        return baseMapper.selectDiseasePositionNum(startTime,endTime);
    }
    //病害信息页 病害严重程度-数量统计
    @Override
    public List<DiseaseDegreeNumDTO> getDiseaseDegreeNum(String startTime, String endTime){
        return baseMapper.selectDiseaseDegreeNum(startTime,endTime);
    }
}
