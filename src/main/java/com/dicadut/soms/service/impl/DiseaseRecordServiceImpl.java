package com.dicadut.soms.service.impl;

import com.dicadut.soms.domain.DiseaseRecord;
import com.dicadut.soms.dto.DiseaseDetailDTO;
import com.dicadut.soms.dto.DiseaseRecordAppListDTO;
import com.dicadut.soms.dto.DiseaseRecordDTO;
import com.dicadut.soms.mapper.DiseaseRecordMapper;
import com.dicadut.soms.service.DiseaseRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //添加病害
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
                diseaseRecord.setBridgeId(diseaseRecordDTO.getPositionId());
                diseaseRecord.setDiseaseAttributeId(item.getDiseaseAttributeId());
                diseaseRecord.setContent(item.getContent());
                diseaseRecord.setType(item.getType());
                list.add(diseaseRecord);
            }
        }

        // 3. 批量插入
        saveBatch(list);
    }

    //App添加病害后,添加病害页显示病害记录
    @Override
    public List<DiseaseRecordAppListDTO> getDiseaseRecordAppList(String taskId, String componentId, String positionId) {
        return baseMapper.selectDiseaseRecordAppList(taskId,componentId,positionId);
    }

    //App删除病害记录
    @Override
    public List<DiseaseRecord> getDiseaseRecordDeleteList(String taskId, String componentId, String positionId,String diseaseId) {
        return baseMapper.selectDiseaseRecordDeleteList(taskId,componentId,positionId,diseaseId);
    }

    //App添加病害后,点击病害记录显示病害详情
    @Override
    public List<DiseaseDetailDTO> getDiseaseDetailList(String taskId, String componentId, String positionId, String diseaseId) {

        return baseMapper.selectDiseaseDetailList(taskId,componentId,positionId,diseaseId);
    }
}
