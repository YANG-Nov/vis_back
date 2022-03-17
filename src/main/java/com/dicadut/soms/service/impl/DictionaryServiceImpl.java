package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Dictionary;
import com.dicadut.soms.dto.TypeNameDTO;
import com.dicadut.soms.enumeration.SomsConstant;
import com.dicadut.soms.mapper.DictionaryMapper;
import com.dicadut.soms.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
     * 该方法通过前方路径参数得到的类型返回所属的类型名称
     *
     * @param type 类型id
     * @return 任务类型名称或构件频率名称列表
     */

    @Override
    public List<TypeNameDTO> getTypeNames(String type) {
        QueryWrapper<Dictionary> dictionaryQueryWrapper = new QueryWrapper<>();
        List<Dictionary> dictionaries = baseMapper.selectList(dictionaryQueryWrapper.eq(SomsConstant.TYPE, type));

        List<TypeNameDTO> typeNameDTOS = dictionaries.stream().map(dictionary -> {
            TypeNameDTO typeNameDTO = new TypeNameDTO();
            BeanUtils.copyProperties(dictionary,typeNameDTO);
            return typeNameDTO;
        }).collect(Collectors.toList());
        return typeNameDTOS;
    }
}
