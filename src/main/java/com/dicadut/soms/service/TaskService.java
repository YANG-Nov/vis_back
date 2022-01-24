package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.dto.viewmodel.PageResult;
import com.dicadut.soms.vo.TaskQueryVO;
import com.dicadut.soms.vo.TaskVO;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:37
 */
public interface TaskService extends IService<Task> {

    List<TaskDTO> getTaskStatusLatestList();

//    List<TaskNumDTO> getTaskNumList();

    PageResult<AmendingTaskDTO> getAmendingTaskList(Integer current, Integer size, TaskQueryVO taskQueryVO);

    List<TaskDisplayDTO> getUnclaimedTaskList();

    List<TaskDisplayDTO> getAreInspectionTaskList();

    List<TaskDisplayDTO> getCompletedTaskList();

    TaskStatisticDTO getThisYearTaskList(String startTime, String endTime);

    TaskStatisticDTO getThisYearTaskListByMultiSql(String startTime, String endTime);

    TaskStatisticDTO getThisYearTaskListBySingleSql(String startTime, String endTime);

    TaskStatisticAppDTO getThisMonthTaskListBySingleSql(String startTime, String endTime);

    List<InspectorDTO> getInspectorList();

    List<TaskAppListDTO> getTaskAppList(Integer taskStatus, Integer inspectionFrequency);

    TaskDetailsDTO getTaskDetails(String taskId);

    void saveTask(TaskVO taskVO);


    void distributeTask(String taskId, String userId);

    TaskContentDTO getTaskContent(String taskId);

    /**
     * App任务对应的打卡点
     * @param taskId 任务id
     * @return  打卡点列表
     */
    List<TaskScanPositionAppListDTO> getTaskScanPositionAppList(String taskId);
}
