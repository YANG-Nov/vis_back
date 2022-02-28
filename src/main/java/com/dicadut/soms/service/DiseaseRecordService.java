package com.dicadut.soms.service;

import com.dicadut.soms.domain.DiseaseRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.DiseaseDetailDTO;
import com.dicadut.soms.dto.DiseaseRecordAppListDTO;
import com.dicadut.soms.dto.DiseaseRecordDTO;

import java.util.Collection;
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

    /**
     * App添加病害后,添加病害页显示病害记录
     * @param taskId 任务id
     * @param componentId 构件id
     * @param positionId 桩号id
     * @return 病害记录
     */
    List<DiseaseRecordAppListDTO> getDiseaseRecordAppList(String taskId, String componentId, String positionId);

    /**
     * App所要删除的病害记录查询
     * @param taskId 任务id
     * @param componentId 构件id
     * @param positionId 位置id
     * @param diseaseId 病害id
     * @return 所要删除的病害记录list
     */
    List<DiseaseRecord> getDiseaseRecordDeleteList(String taskId, String componentId, String positionId,String diseaseId);

    List<DiseaseDetailDTO> getDiseaseDetailList(String taskId, String componentId, String positionId, String diseaseId);
}
