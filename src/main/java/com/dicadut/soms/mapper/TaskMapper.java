package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:41
 */
@Mapper
public interface TaskMapper extends BaseMapper<Task> {

    Integer selectCountByTaskStatus(@Param("startTime") String startTime,
                                    @Param("endTime") String endTime,
                                    @Param("taskStatus") String taskStatus);

    TaskStatisticDTO selectTaskStatisticByTaskStatus(@Param("startTime") String startTime,
                                                     @Param("endTime") String endTime);

    TaskStatisticAppDTO selectTaskStatisticAppByTaskStatus(@Param("startTime") String startTime,
                                                           @Param("endTime") String endTime);

    List<TaskUserDistributeDTO> selectTaskUserDistributeList();

    List<TaskWaitConfirmAppListDTO> selectTaskWaitConfirmAppList();

    TaskDetailsDTO selectTaskDetails(@Param("taskId") String taskId);

    List<TaskDTO> selectTaskStatusLatestList();
}
