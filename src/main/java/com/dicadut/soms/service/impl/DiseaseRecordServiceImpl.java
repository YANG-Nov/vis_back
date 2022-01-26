package com.dicadut.soms.service.impl;

import com.dicadut.soms.domain.DiseaseRecord;
import com.dicadut.soms.dto.DiseaseRecordDTO;
import com.dicadut.soms.mapper.DiseaseRecordMapper;
import com.dicadut.soms.service.DiseaseRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 病害记录表 服务实现类
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-26
 */
@Service
public class DiseaseRecordServiceImpl extends ServiceImpl<DiseaseRecordMapper, DiseaseRecord> implements DiseaseRecordService {

    @Override
    public void addDiseaseRecords(DiseaseRecordDTO diseaseRecordDTO) {
        if (diseaseRecordDTO == null) {
            return;
        }

        // 1. 将6个list合并到1个list上
        List<DiseaseRecordDTO.Item> items = new ArrayList<>();
        items.addAll(diseaseRecordDTO.getFeatureFields());
        items.addAll(diseaseRecordDTO.getFeaturePopups());
        items.addAll(diseaseRecordDTO.getFeatureRadios());
        items.addAll(diseaseRecordDTO.getDiseasePictures());
        items.addAll(diseaseRecordDTO.getDiseaseVoices());
        items.addAll(diseaseRecordDTO.getDiseaseTexts());

        // 2. 将合并后的list转换成与数据库一致的格式
        List<DiseaseRecord> list = new ArrayList<>();
        if (items.size() != 0) {
            for (DiseaseRecordDTO.Item item : items) {
                DiseaseRecord diseaseRecord = new DiseaseRecord();
                diseaseRecord.setDiseaseId(diseaseRecordDTO.getDiseaseId());
                diseaseRecord.setComponentId(diseaseRecordDTO.getComponentId());
                diseaseRecord.setTaskId(diseaseRecordDTO.getTaskId());
                diseaseRecord.setBridgeInfoId(diseaseRecordDTO.getPositionId());
                diseaseRecord.setDiseaseAttributeId(item.getDiseaseAttributeId());
                diseaseRecord.setContent(item.getContent());
                diseaseRecord.setType(item.getType());
                list.add(diseaseRecord);
            }
        }

        // 3. 批量插入
        saveBatch(list);
    }
}