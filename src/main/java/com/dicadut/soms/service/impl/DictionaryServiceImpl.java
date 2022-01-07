package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.BLineStakeNumberDTO;
import com.dicadut.soms.dto.BLineStakeNumberMinMaxDTO;
import com.dicadut.soms.dto.InspectionFrequencyDTO;
import com.dicadut.soms.dto.TaskTypeDTO;
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
     * TODO
     * 该方法首先将构件频率类型从数据库中读取到内存，再用循坏把类型名称列添加到列表，数据较少
     * 后面再优化循环，mapper和相同代码提取
     *
     * @return componentsFrequency
     */
    @Override
    public List<InspectionFrequencyDTO> getComponentsFrequency() {
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", TypeNameEnum.COMPONENT_INSPECTION_FREQUENCY.getValue());
        List<InspectionFrequencyDTO> componentsFrequency = new ArrayList<>();

        List<Dictionary> dictionaries = baseMapper.selectList(queryWrapper);

        for (Dictionary d :
                dictionaries) {
            InspectionFrequencyDTO inspectionFrequencyDTO = new InspectionFrequencyDTO();
            BeanUtils.copyProperties(d, inspectionFrequencyDTO);
            componentsFrequency.add(inspectionFrequencyDTO);

        }
        return componentsFrequency;
    }

    /**
     * TODO 和上个方法相同
     * 该方法首先将构件频率类型从数据库中读取到内存，再用循坏把类型名称列添加到列表，数据较少
     * 后面再优化循环，mapper和相同代码提取
     *
     * @return componentsFrequency
     */
    @Override
    public List<TaskTypeDTO> getTaskType() {
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", TypeNameEnum.TASK_TYPE.getValue());
        List<TaskTypeDTO> taskTypeDTOS = new ArrayList<>();

        List<Dictionary> dictionaries = baseMapper.selectList(queryWrapper);

        for (Dictionary d :
                dictionaries) {
            TaskTypeDTO taskTypeDTO = new TaskTypeDTO();
            BeanUtils.copyProperties(d, taskTypeDTO);
            taskTypeDTOS.add(taskTypeDTO);

        }
        return taskTypeDTOS;

    }

    /**
     * TODO 和下个方法接口相同，返回格式不一样
     * 该方法首先将构件频率类型从数据库中读取到内存，再用循坏把类型名称列添加到列表，数据较少
     * 后面再优化循环，mapper和相同代码提取
     *
     * @return componentsFrequency
     */
    @Override
    public List<BLineStakeNumberDTO> getBLineStakeNumber() {
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", TypeNameEnum.B_LINE_STAKE_NUMBER.getValue());
        List<BLineStakeNumberDTO> bLineStakeNumberDTOS = new ArrayList<>();

        List<Dictionary> dictionaries = baseMapper.selectList(queryWrapper);

        for (Dictionary d :
                dictionaries) {
            BLineStakeNumberDTO bLineStakeNumberDTO = new BLineStakeNumberDTO();
            BeanUtils.copyProperties(d, bLineStakeNumberDTO);
            bLineStakeNumberDTOS.add(bLineStakeNumberDTO);

        }
        return bLineStakeNumberDTOS;
    }

    @Override
    public BLineStakeNumberMinMaxDTO getBLineStakeNumberMinMax() {
        BLineStakeNumberMinMaxDTO bLineStakeNumberMinMaxDTO = new BLineStakeNumberMinMaxDTO();
        QueryWrapper<Dictionary> queryWrapperMin = new QueryWrapper<>();
        queryWrapperMin.eq("type", TypeNameEnum.B_LINE_STAKE_NUMBER.getValue()).last("limit 1");
        Dictionary minStakeNumber = baseMapper.selectOne(queryWrapperMin);
        bLineStakeNumberMinMaxDTO.setStartStakeNumber(minStakeNumber.getCodeName());


        QueryWrapper<Dictionary> queryWrapperMax = new QueryWrapper<>();
        queryWrapperMax.eq("type", TypeNameEnum.B_LINE_STAKE_NUMBER.getValue()).orderByDesc("id").last("limit 1");
        Dictionary maxStakeNumber = baseMapper.selectOne(queryWrapperMax);
        bLineStakeNumberMinMaxDTO.setEndStakeNumber(maxStakeNumber.getCodeName());

        return bLineStakeNumberMinMaxDTO;
    }
}
