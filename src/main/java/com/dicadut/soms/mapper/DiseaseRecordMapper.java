package com.dicadut.soms.mapper;

import com.dicadut.soms.domain.DiseaseRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.dto.*;


import java.util.List;

/**
 * <p>
 * 病害记录表 Mapper 接口
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-26
 */
public interface DiseaseRecordMapper extends BaseMapper<DiseaseRecord> {

    List<DiseaseRecordAppListDTO> selectDiseaseRecordAppList(String taskId, String componentId);

    List<DiseaseRecord> selectDiseaseRecordDeleteList(String taskId, Integer recordId);

    List<DiseaseDetailListDTO> selectDiseaseList(String taskId, Integer recordId);

    List<DiseaseDetailListDTO> selectDiseaseAttributeList (String diseaseAttributeId);

    void deleteDiseaseRecord(String taskId, Integer recordId);

    List<DiseaseRecordTableListDTO> selectDiseaseRecordTable(String taskId);

    List<DiseaseRecordHighlightDTO> selectDiseaseRecordHighlight(String taskId);

    DiseaseRecordIdMaxDTO selectDiseaseRecordIdMax(String taskId);
}
