package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.vo.TaskQueryVO;
import com.dicadut.soms.vo.TaskVO;
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

    List<InspectorDTO> selectInspectorList();

    List<TaskEndTimeAppListDTO> selectTaskEndTimeAppList(@Param("taskStatus") Integer taskStatus,
                                                         @Param("inspectionFrequency") Integer inspectionFrequency);

    List<TaskInspectionAppListDTO> selectTaskInspectionAppList(@Param("taskStatus") Integer taskStatus,
                                                     @Param("inspectionFrequency") Integer inspectionFrequency);

    List<TaskDetailsAppListDTO> selectTaskDetailsAppList(@Param("taskStatus") Integer taskStatus,
                                                  @Param("inspectionFrequency") Integer inspectionFrequency);

    TaskDetailsDTO selectTaskDetails(@Param("taskId") String taskId);

    List<TaskDTO> selectTaskStatusLatestList();

    void addTask(@Param("taskId") String taskId,
                 @Param("taskVO") TaskVO taskVO);

    void addTaskComponent(@Param("taskId") String taskId,
                          @Param("list") List<ComponentNumberDTO> componentNumberDTOList);


    void addInspectorToTask(@Param("taskId") String taskId,
                            @Param("userId") String userId);

    IPage<AmendingTaskDTO> getAmendingTaskListByePageQuery(IPage<AmendingTaskDTO> page, @Param("taskQueryVO") TaskQueryVO taskQueryVO);

    String getInspectionPosition(@Param("taskId") String taskId);

    List<ComponentNumberTotalDTO> getComponentNumberRange(@Param("list") List<String> list,
                                                          @Param("taskId") String taskId);

    List<String> getComponentList(@Param("taskId") String taskId);

    List<InspectorTaskDTO> selectTaskByInspector(@Param("id") String id);

    List<TaskScanPositionAppListDTO> selectTaskScanPositionAppList(String taskId);
}
