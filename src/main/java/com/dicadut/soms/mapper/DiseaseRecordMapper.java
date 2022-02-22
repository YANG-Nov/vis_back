package com.dicadut.soms.mapper;

import com.dicadut.soms.domain.DiseaseRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.dto.DiseaseDetailsDTO;
import com.dicadut.soms.dto.DiseaseRecordAppListDTO;
import com.dicadut.soms.dto.InspectorTaskDTO;
import org.apache.ibatis.annotations.Param;

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

    List<DiseaseDetailsDTO> selectFeatureFields(String taskId, String componentId, String positionId, String diseaseId);
    List<DiseaseDetailsDTO> selectFeaturePopups(String taskId, String componentId, String positionId, String diseaseId);
    List<DiseaseDetailsDTO> selectFeatureRadios(String taskId, String componentId, String positionId, String diseaseId);
    List<DiseaseDetailsDTO> selectDiseasePictures(String taskId, String componentId, String positionId, String diseaseId);
    List<DiseaseDetailsDTO> selectDiseaseVoices(String taskId, String componentId, String positionId, String diseaseId);
    List<DiseaseDetailsDTO> selectDiseaseTexts(String taskId, String componentId, String positionId, String diseaseId);

    List<DiseaseRecord> selectDiseaseRecordDeleteList(String taskId, String componentId, String positionId,String diseaseId);
}
