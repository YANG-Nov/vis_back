package com.dicadut.soms.service;

import com.dicadut.soms.domain.DiseaseRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.DiseaseRecordAppListDTO;
import com.dicadut.soms.dto.DiseaseRecordDTO;

import java.util.List;

/**
 * <p>
 * 病害记录表 服务类
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-26
 */
public interface DiseaseRecordService extends IService<DiseaseRecord> {

    /**
     * 批量添加病害
     *
     * @param diseaseRecordDTO
     */
    void addDiseaseRecords(DiseaseRecordDTO diseaseRecordDTO);

    List<DiseaseRecordAppListDTO> getDiseaseRecordAppList(String taskId, String componentId);
}
