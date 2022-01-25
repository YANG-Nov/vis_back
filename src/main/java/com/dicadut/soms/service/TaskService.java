package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.AmendingTaskDTO;
import com.dicadut.soms.dto.InspectorDTO;
import com.dicadut.soms.dto.TaskAppListDTO;
import com.dicadut.soms.dto.TaskContentDTO;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.dto.TaskDetailsDTO;
import com.dicadut.soms.dto.TaskDisplayDTO;
import com.dicadut.soms.dto.TaskScanPositionAppListDTO;
import com.dicadut.soms.dto.TaskStatisticAppDTO;
import com.dicadut.soms.dto.TaskStatisticDTO;
import com.dicadut.soms.dto.viewmodel.Page;
import com.dicadut.soms.vo.TaskQueryVO;
import com.dicadut.soms.vo.TaskVO;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:37
 */
public interface TaskService extends IService<Task> {

    /**
     * 查询任务状态数量，扇形图
     *
     * @return
     */
    List<TaskDTO> getTaskStatusLatestList();

    /**
     * 条件查询分页
     *
     * @param currentPage 第几页
     * @param pageSize    页大小
     * @param taskQueryVO 查询条件
     * @return PageResult<AmendingTaskDTO>
     * @author fan_jane
     */
    Page<AmendingTaskDTO> getAmendingTaskList(Integer currentPage, Integer pageSize, TaskQueryVO taskQueryVO);

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
     *
     * @param taskId 任务id
     * @return 打卡点列表
     */
    List<TaskScanPositionAppListDTO> getTaskScanPositionAppList(String taskId);
}
