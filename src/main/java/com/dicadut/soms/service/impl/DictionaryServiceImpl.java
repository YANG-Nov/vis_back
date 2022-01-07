package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.InspectionFrequencyDTO;
import com.dicadut.soms.entity.Dictionary;
import com.dicadut.soms.enumeration.TypeNameEnum;
import com.dicadut.soms.mapper.DictionaryMapper;
import com.dicadut.soms.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-01-03
 */
@Service
@Slf4j
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    /**
     *TODO
     * 该方法首先将构件频率类型从数据库中读取到内存，再用循坏把类型名称列添加到列表，
     * 后面再优化
     *
     *
     *
     * @return componentsFrequency
     */
    @Override
    public List<InspectionFrequencyDTO> getComponentsFrequency() {
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", TypeNameEnum.COMPONENT_INSPECTION_FREQUENCY.getValue());
        List<InspectionFrequencyDTO> componentsFrequency = new ArrayList<>();

        List<Dictionary> dictionaries = baseMapper.selectList(queryWrapper);

        for (Dictionary d:
             dictionaries) {
            InspectionFrequencyDTO inspectionFrequencyDTO = new InspectionFrequencyDTO();
            BeanUtils.copyProperties(d, inspectionFrequencyDTO);
            componentsFrequency.add(inspectionFrequencyDTO);

        }
        return componentsFrequency;
    }
}
