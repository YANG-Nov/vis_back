package com.dicadut.soms.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.CmponentDTO;
import com.dicadut.soms.dto.DieaseDTO;
import com.dicadut.soms.entity.Cmponent;
import com.dicadut.soms.entity.Disease;
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
    public List<DieaseDTO> getDieaseList() {


        List<Disease> diseases = baseMapper.selectList(null);
        ArrayList<DieaseDTO> diseasesDTO = new ArrayList<>();
        for (int i = 0; i < diseases.size(); i++) {
            DieaseDTO diseaseDTO = new DieaseDTO();

            BeanUtils.copyProperties(diseases.get(i),diseaseDTO);

            diseasesDTO.add(diseaseDTO);
        }



        return diseasesDTO;
    }
}
