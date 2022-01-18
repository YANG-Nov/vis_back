package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.DiseaseAppListDTO;
import com.dicadut.soms.dto.DiseaseAttributeListDTO;
import com.dicadut.soms.domain.Disease;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
public interface DiseaseService extends IService<Disease> {

    List<DiseaseAppListDTO> getDiseaseList();

    List<DiseaseAppListDTO> getDiseaseAppList(Integer componentId);

    /**
     * App添加病害，不同病害对应的病害特性以及特性值
     * @param diseaseId 病害id
     * @return 病害列表
     */
    List<DiseaseAttributeListDTO> getDiseaseAttributeAppList(Integer diseaseId);
}
