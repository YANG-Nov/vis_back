package com.dicadut.soms.mapper;

import com.dicadut.soms.domain.DiseaseRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.dto.DiseaseDetailListDTO;
import com.dicadut.soms.dto.DiseaseRecordAppListDTO;


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

    List<DiseaseRecordAppListDTO> selectDiseaseRecordAppList(String taskId, String componentId, String positionId);

    List<DiseaseRecord> selectDiseaseRecordDeleteList(String taskId, String componentId, String positionId,String diseaseId);

    List<DiseaseDetailListDTO> selectDiseaseDetailList(String taskId, String componentId, String positionId, String diseaseId);
}
