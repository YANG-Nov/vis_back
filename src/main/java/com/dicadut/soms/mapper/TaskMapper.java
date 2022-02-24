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

    // Wei_TODO 2022/2/24 1状态提到Java层做 2查询层级改成韦雷哥代码
    List<InspectorDTO> selectInspectorList();

    List<TaskEndTimeAppListDTO> selectTaskEndTimeAppList(@Param("taskStatus") Integer taskStatus,
                                                         @Param("inspectionFrequency") Integer inspectionFrequency);

    List<TaskInspectionAppListDTO> selectTaskInspectionAppList(@Param("taskStatus") Integer taskStatus,
                                                               @Param("inspectionFrequency") Integer inspectionFrequency);

    List<TaskDetailsAppListDTO> selectTaskDetailsAppList(@Param("taskStatus") Integer taskStatus,
                                                         @Param("inspectionFrequency") Integer inspectionFrequency);

    List<TaskDTO> selectTaskStatusLatestList();

    /**
     * 添加任务信息，并把任务状态设置为 1002000004 待分配
     *
     * @param taskId 自动生成的任务id
     * @param taskVO 前端传过来的任务信息
     * @author FanJane
     */
    @Deprecated
    void addTask(@Param("taskId") String taskId,
                 @Param("taskVO") TaskVO taskVO);


    void addInspectorToTask(@Param("taskId") String taskId,
                            @Param("userId") String userId);

    IPage<AmendingTaskDTO> getAmendingTaskListByePageQuery(IPage<AmendingTaskDTO> page, @Param("taskQueryVO") TaskQueryVO taskQueryVO);

    String getInspectionPosition(@Param("taskId") String taskId);

    @Deprecated
    List<ComponentNumberTotalDTO> getComponentNumberRange(@Param("list") List<String> list,
                                                          @Param("taskId") String taskId);

    List<String> getComponentList(@Param("taskId") String taskId);

    List<TaskScanPositionAppListDTO> selectTaskScanPositionAppList(String taskId);
}
