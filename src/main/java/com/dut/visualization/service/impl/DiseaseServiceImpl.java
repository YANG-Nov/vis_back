package com.dut.visualization.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dut.visualization.domain.Disease;
import com.dut.visualization.dto.DiseaseDegreeNumDTO;
import com.dut.visualization.dto.DiseaseLocationDTO;
import com.dut.visualization.dto.DiseasePlaceNumDTO;
import com.dut.visualization.dto.DiseasePositionNumDTO;
import com.dut.visualization.dto.DiseaseSelectByCodeAndRepair;
import com.dut.visualization.dto.DiseaseTimeNumDTO;
import com.dut.visualization.dto.DiseaseTypeDTO;
import com.dut.visualization.dto.DiseaseTypeNumDTO;
import com.dut.visualization.dto.DiseaseZtTimeDTO;
import com.dut.visualization.dto.DiseaseZtTimeDTO1;
import com.dut.visualization.mapper.DiseaseMapper;
import com.dut.visualization.service.DiseaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 10:30 上午 2023/4/27
 * @ Description：病害信息实现类
 * @Version: 1.0.0$
 */
@Slf4j
@Service
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease> implements DiseaseService {
    //获取病害位置及严重程度
    @Override
    public List<DiseaseLocationDTO> getDiseaseLocationList(String startTime, String endTime) {
        return baseMapper.selectDiseaseLocationList(startTime, endTime);
    }

    //病害信息页 病害部位-数量统计（主体、接头、附属）
    @Override
    public List<DiseasePlaceNumDTO> getDiseasePlaceNumList(String startTime, String endTime) {
        return baseMapper.selectDiseasePlaceNumList(startTime, endTime);
    }

    //主体结构病害发生时间统计
    @Override
    public List<DiseaseZtTimeDTO> getDiseaseZtTimeList(String startTime, String endTime) {
        List<DiseaseZtTimeDTO1> list = baseMapper.selectDiseaseZtTimeList(startTime, endTime);
        List<DiseaseZtTimeDTO> list1 = new ArrayList<>();
        int value = 0;
        for (DiseaseZtTimeDTO1 diseaseZtTimeDTO1 : list) {
            DiseaseZtTimeDTO diseaseZtTimeDTO = new DiseaseZtTimeDTO();
            if (diseaseZtTimeDTO1.getIsRepair() == 0) {
                diseaseZtTimeDTO.setValue(++value);
                diseaseZtTimeDTO.setCreateTime(diseaseZtTimeDTO1.getCreateTime());
                list1.add(diseaseZtTimeDTO);
                //todo 需要判断disease_code在已循环完的数据中是否有重复,
                // 有重复的话，value值不变；无重复的话，value值+1
            }
            if (diseaseZtTimeDTO1.getIsRepair() == 1) {
                diseaseZtTimeDTO.setValue(--value);
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
    public List<DiseaseTypeNumDTO> getDiseaseTypeNumList(String diseaseParentId, String startTime, String endTime) {
        return baseMapper.selectDiseaseTypeNumList(diseaseParentId, startTime, endTime);
    }

    //病害信息页 病害位置-数量统计
    @Override
    public List<DiseasePositionNumDTO> getDiseasePositionNum(String startTime, String endTime) {
        return baseMapper.selectDiseasePositionNum(startTime, endTime);
    }

    //病害信息页 病害严重程度-数量统计
    @Override
    public List<DiseaseDegreeNumDTO> getDiseaseDegreeNum(String startTime, String endTime) {
        return baseMapper.selectDiseaseDegreeNum(startTime, endTime);
    }

    //病害信息页 病害发生时间-数量统计
    @Override
    public List<DiseaseTimeNumDTO> getDiseaseTimeNum(String startTime, String endTime, String diseaseId) {
        log.info("startTime:{},endTime:{},diseaseId:{}", startTime, endTime, diseaseId);
        List<DiseaseSelectByCodeAndRepair> diseaseSelectByCodeAndRepairList = baseMapper.selectByCodeAndRepair(startTime, endTime, diseaseId);
        log.info("diseaseSelectByCodeAndRepairList:{}", diseaseSelectByCodeAndRepairList);
        List<DiseaseTimeNumDTO> list = new ArrayList<>();

        if (CollUtil.isNotEmpty(diseaseSelectByCodeAndRepairList)) {
            DateTime start = DateUtil.parseDate(startTime); // i 入参
            DateTime end = DateUtil.parseDate(endTime); // c 入参

            Map<String, List<DiseaseSelectByCodeAndRepair>> codeMap = diseaseSelectByCodeAndRepairList.stream().collect(Collectors.groupingBy(DiseaseSelectByCodeAndRepair::getDiseaseCode));
            ConcurrentHashMap<String, AtomicInteger> countByDayMap = new ConcurrentHashMap<>();
            for (String diseaseCode : codeMap.keySet()) {
                List<DiseaseSelectByCodeAndRepair> diseaseSelectByCodeAndRepairs = codeMap.get(diseaseCode);
                DateTime sDate = DateUtil.parseDate(diseaseSelectByCodeAndRepairs.get(0).getTriggerDate()); // 病害发生日期，肯定不为空
                DateTime eDate = diseaseSelectByCodeAndRepairs.size() >= 2 ? DateUtil.parseDate(diseaseSelectByCodeAndRepairs.get(1).getTriggerDate()) : null; // 病害修复日期，为空时说明病害未修复

                DateTime s = new DateTime((sDate.isBefore(start) ? start : sDate).getTime());   // s要新new一个，因为在calculateCount中会改变s的值，导致sDate的值也会改变
                DateTime e = new DateTime((eDate == null || eDate.isAfter(end) ? end : eDate).getTime());   // e要新new一个，因为在calculateCount中会改变e的值，导致eDate的值也会改变
                calculateCount(s, e, countByDayMap);
                log.info("s:{},e:{},countByDayMap:{}", s, e, countByDayMap);
            }

            // 将map转换为list
            for (Map.Entry<String, AtomicInteger> entry : countByDayMap.entrySet()) {
                DiseaseTimeNumDTO diseaseTimeNumDTO = new DiseaseTimeNumDTO();
                diseaseTimeNumDTO.setName(entry.getKey());
//                diseaseTimeNumDTO.setValue(String.valueOf(entry.getValue().get()));
                diseaseTimeNumDTO.setValue(entry.getValue().get());
                list.add(diseaseTimeNumDTO);
            }
        }

        return list;
    }

    /**
     * 计算每天的数量
     *
     * @param start         开始日期
     * @param end           结束日期
     * @param countByDayMap 每天的数量
     */
    private void calculateCount(DateTime start, DateTime end, ConcurrentHashMap<String, AtomicInteger> countByDayMap) {
        while (start.isBefore(end)) {
            String key = start.toString("yyyy-MM-dd");
            if (countByDayMap.containsKey(key)) {
                countByDayMap.get(key).incrementAndGet();
            } else {
                countByDayMap.put(key, new AtomicInteger(1));
            }
            start = start.offset(DateField.DAY_OF_YEAR, 1);
        }
    }
}
