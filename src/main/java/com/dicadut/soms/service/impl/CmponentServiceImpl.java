package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.CmponentDTO;
import com.dicadut.soms.entity.Cmponent;
import com.dicadut.soms.entity.Strain;
import com.dicadut.soms.mapper.CmponentMapper;
import com.dicadut.soms.mapper.StrainMapper;
import com.dicadut.soms.service.CmponentService;
import com.dicadut.soms.service.StrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/21 14:11
 */
@Slf4j
@Service
public class CmponentServiceImpl extends ServiceImpl<CmponentMapper, Cmponent> implements CmponentService {
    @Override
    public List<CmponentDTO> getFrequencyList() {

        List<Cmponent> cmponents = baseMapper.selectList(null);
        int value = 0;
        ArrayList<CmponentDTO> cmponentsDTO = new ArrayList<>();
        for (int i = 0; i < cmponents.size(); i++) {
            CmponentDTO cmponentDTO = new CmponentDTO();

            BeanUtils.copyProperties( cmponents.get(i), cmponentDTO);

            cmponentDTO.setValue(++value);

            cmponentsDTO.add(cmponentDTO);
        }



        return cmponentsDTO;
    }
}
