package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.TypeNameDTO;
import com.dicadut.soms.domain.Dictionary;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-01-03
 */
public interface DictionaryService extends IService<Dictionary> {

    /**
     * 根据字典表的类型名称，获得所有该类型子类型集合，返回code 和codeName集合
     *
     * @param type 类型名称4位数
     * @return List<TypeNameDTO>code 和codeName集合
     * @author FanJane
     */
    List<TypeNameDTO> getTypeNames(String type);
}
