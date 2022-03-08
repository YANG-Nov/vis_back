package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.vo.InspectionScopeVO;
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
    PageResult<AmendingTaskDTO> getAmendingTaskList(Integer currentPage, Integer pageSize, TaskQueryVO taskQueryVO);

    List<TaskDisplayDTO> getUnclaimedTaskList();

    List<TaskDisplayDTO> getAreInspectionTaskList();

    List<TaskDisplayDTO> getCompletedTaskList();

    TaskStatisticDTO getThisYearTaskList(String startTime, String endTime);

    TaskStatisticDTO getThisYearTaskListByMultiSql(String startTime, String endTime);

    TaskStatisticDTO getThisYearTaskListBySingleSql(String startTime, String endTime);

    TaskStatisticAppDTO getThisMonthTaskListBySingleSql(String startTime, String endTime);

    List<InspectorDTO> getInspectorList();

    List<TaskAppListDTO> getTaskAppList(Integer taskStatus);

    /**
     * 选择完构件后，点击确认添加，将任务和任务构件信息传输到数据库存储
     * 前端传过来两级对象，第一级为任务信息，第二级为构件信息
     *
     * @param taskVO 添加的任务信息
     * @return //暂时没有 Jane_TODO 2022/2/24 后期需要优化
     * @author FanJane
     */
    void saveTask(TaskVO taskVO);

    void distributeTask(String taskId, String userId);

    /**
     * 在添加完任务之后跳转的到任务列表例，点击查看按钮，查看该行任务详情
     * 前端传过来当前行的任务id，
     *
     * @param taskId 当前任务id
     * @return 返回二级任务列表，一级为巡检位置，二级为构件
     * @author FanJane
     */
    @Deprecated
    TaskContentDTO getTaskContent(String taskId);

    /**
     * App任务对应的打卡点
     *
     * @param taskId 任务id
     * @return 打卡点列表
     */
    List<TaskScanPositionAppListDTO> getTaskScanPositionAppList(String taskId);

    /**
     * // Jane_TODO add description
     *
     * @param taskId
     * @return com.dicadut.soms.dto.TaskContentDTO
     * @author FanJane
     */
    TaskContentDTO showTaskContent(String taskId);

    /**
     * 选择巡检范围后弹出所有打卡位置，并默认勾选构件包含的打卡位置
     *
     * @param inspectionScopeVO 巡检范围起始桩号
     * @return CheckBox <ScanPositionDTO> 显示打卡位置
     * @author FanJane
     */
    CheckBox<ScanPositionDTO> getTaskScanPosition(InspectionScopeVO inspectionScopeVO);

    /**
     * // Jane_TODO add description
     *
     * @param taskId
     * @return void
     * @author FanJane
     */
    void removeTask(String taskId);

    /**
     * 对任务状态进行更新操作
     * @param taskId 要更新状态的任务id
     * @param taskStatusIdGo 要更新到的目标状态
     */
    void updateTaskStatus(String taskId, String taskStatusIdGo);
}
