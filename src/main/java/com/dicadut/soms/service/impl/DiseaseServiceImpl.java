package com.dicadut.soms.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.DiseaseAppListDTO;
import com.dicadut.soms.dto.DiseaseAttributeListDTO;
import com.dicadut.soms.domain.Disease;
import com.dicadut.soms.mapper.DiseaseMapper;
import com.dicadut.soms.service.DiseaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
@Slf4j
@Service
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease> implements DiseaseService {

    @Override
    public List<DiseaseAppListDTO> getDiseaseList() {


        List<Disease> diseases = baseMapper.selectList(null);
        ArrayList<DiseaseAppListDTO> diseasesDTO = new ArrayList<>();
        for (int i = 0; i < diseases.size(); i++) {
            DiseaseAppListDTO diseaseDTO = new DiseaseAppListDTO();

            BeanUtils.copyProperties(diseases.get(i),diseaseDTO);

            diseasesDTO.add(diseaseDTO);
        }



        return diseasesDTO;
    }

    //App添加病害，不同构件对应的病害列表
    public List<DiseaseAppListDTO> getDiseaseAppList(Integer componentId) {
        return baseMapper.selectDiseaseAppList(componentId);
    }

    //App添加病害，不同病害对应的病害特性以及特性值
    public List<DiseaseAttributeListDTO> getDiseaseAttributeAppList(Integer diseaseId) {
        return baseMapper.selectDiseaseAttributeAppList(diseaseId);
    }
}
