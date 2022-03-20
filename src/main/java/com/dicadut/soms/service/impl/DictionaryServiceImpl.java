package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Dictionary;
import com.dicadut.soms.dto.TypeNameDTO;
import com.dicadut.soms.enumeration.FrequencyEnum;

import com.dicadut.soms.enumeration.TaskTypeEnum;
import com.dicadut.soms.enumeration.TypeNameEnum;
import com.dicadut.soms.exception.TaskException;
import com.dicadut.soms.mapper.DictionaryMapper;
import com.dicadut.soms.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
     * 该方法通过前方路径参数得到的类型返回所属的类型名称
     *
     * @param type 类型id
     * @return 任务类型名称或构件频率名称列表
     */

    @Override
    public List<TypeNameDTO> getTypeNames(String type) {
        if (TypeNameEnum.COMPONENT_INSPECTION_FREQUENCY.getValue().equals(type)) {
            return FrequencyEnum.getAllEnum();
        }
        if (TypeNameEnum.TASK_TYPE.getValue().equals(type)) {
            return TaskTypeEnum.getAllEnum();
        }
        if(TypeNameEnum.SCAN_POSITION.getValue().equals(type)){
            return TaskTypeEnum.getAllEnum();
        }
        throw new TaskException(20001, "输入类型错误");

    }

}
