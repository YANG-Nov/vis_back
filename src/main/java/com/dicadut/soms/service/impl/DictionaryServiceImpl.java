package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.entity.Dictionary;
import com.dicadut.soms.mapper.DictionaryMapper;
import com.dicadut.soms.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}
