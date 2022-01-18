package com.dicadut.soms.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.dto.DiseaseAppListDTO;
import com.dicadut.soms.dto.DiseaseAttributeListDTO;
import com.dicadut.soms.domain.Disease;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
public interface DiseaseMapper extends BaseMapper<Disease> {

    List<DiseaseAppListDTO> selectDiseaseAppList(Integer componentId);

    List<DiseaseAttributeListDTO> selectDiseaseAttributeAppList(Integer diseaseId);
}
