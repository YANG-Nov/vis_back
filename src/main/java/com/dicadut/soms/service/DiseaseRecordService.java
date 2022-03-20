package com.dicadut.soms.service;

import com.dicadut.soms.domain.DiseaseRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.*;

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
     * @return 病害记录
     */
    List<DiseaseRecordAppListDTO> getDiseaseRecordAppList(String taskId, String componentId);

    /**
     * App所要删除的病害记录查询
     * @param taskId 任务id
     * @param recordId 病害记录id
     * @return 所要删除的病害记录list
     */
    List<DiseaseRecord> getDiseaseRecordDeleteList(String taskId, Integer recordId);

    /**
     * App添加病害后,点击病害记录显示病害详情
     * @param taskId 任务id
     * @param recordId 病害记录id
     * @return 显示病害详情
     */
    DiseaseDetailDTO getDiseaseDetailList(String taskId, Integer recordId);

    /**
     * 批量删除病害（非逻辑删）
     * @param diseaseRecordDTO
     */
    void deleteDiseaseRecord(DiseaseRecordDTO diseaseRecordDTO);

    List<DiseaseRecordTableDTO> getDiseaseRecordTable(String taskId);
}
