package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.dto.ComponentDTO;
import com.dicadut.soms.entity.TaskSetMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 任务套餐表 Mapper 接口
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-17
 */
public interface TaskSetMenuMapper extends BaseMapper<TaskSetMenu> {

    void insertMenu(@Param("menuName") String menuName);

    void insertMenuComponent(@Param("menuId") String menuName,
                             @Param("list") List<ComponentDTO> componentDTOList);
}
