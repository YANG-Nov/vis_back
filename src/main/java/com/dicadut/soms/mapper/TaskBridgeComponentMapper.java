package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.domain.TaskBridgeComponent;
import com.dicadut.soms.dto.SubTaskAddVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 任务桥构件表 Mapper 接口
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-27
 */
public interface TaskBridgeComponentMapper extends BaseMapper<TaskBridgeComponent> {

    /**
     * 向任务构件表里插入构件编号id和任务id
     *
     * @param taskId
     * @param componentNumberDTOList
     * @return void
     * @author FanJane
     */
    void addTaskComponent(@Param("taskId") String taskId,
                          @Param("list") List<SubTaskAddVO> subTaskAddVOS);


}
