package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.TypeNameDTO;
import com.dicadut.soms.entity.Dictionary;

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


    List<TypeNameDTO> getTypeNames(String type);
}
