package com.dut.visualization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.DiseaseLocationDTO;
import com.dut.visualization.dto.DiseaseTypeDTO;
import com.dut.visualization.mapper.DiseaseMapper;
import com.dut.visualization.service.DiseaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    //病害信息页 数据分类统计柱状图
    @Override
    public List<DiseaseTypeDTO> getDiseaseTypeList(String startTime, String endTime){
        return baseMapper.selectDiseaseTypeList(startTime,endTime);
    }
}
