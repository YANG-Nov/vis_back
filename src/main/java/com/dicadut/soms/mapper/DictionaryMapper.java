package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.dto.TypeNameDTO;
import com.dicadut.soms.domain.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-01-03
 */
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    List<TypeNameDTO> selectCodeNameListByType(@Param("type") String type);
}
