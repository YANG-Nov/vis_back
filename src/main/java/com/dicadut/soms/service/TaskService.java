package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.vo.*;

import java.lang.reflect.InvocationTargetException;
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
    PageResult<TaskSetDTO> getTaskList(Integer currentPage, Integer pageSize, TaskQueryVO taskQueryVO);

    List<TaskDisplayDTO> getUnclaimedTaskList();

    List<TaskDisplayDTO> getAreInspectionTaskList();

    List<TaskDisplayDTO> getCompletedTaskList();

    TaskStatisticDTO getThisYearTaskList(String startTime, String endTime);

    TaskStatisticDTO getThisYearTaskListByMultiSql(String startTime, String endTime);

    TaskStatisticDTO getThisYearTaskListBySingleSql(String startTime, String endTime);

    TaskStatisticAppDTO getThisMonthTaskListBySingleSql(String startTime, String endTime, String userId);

    List<InspectorTaskDTO> getInspectorList() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    List<TaskAppListDTO> getTaskAppList(Integer taskStatus, String userId);

    /**
     * 选择完构件后，点击确认添加，将任务和任务构件信息传输到数据库存储
     * 前端传过来两级对象，第一级为任务信息，第二级为构件信息
     *
     * @param taskVO 添加的任务信息
     *               //暂时没有 Jane_TODO 2022/2/24 后期需要优化
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
    TaskContentDTO<SubTaskShowV0> getTaskContent(String taskId);

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
     * @param taskId 任务id
     * @return com.dicadut.soms.dto.TaskContentDTO
     * @author FanJane
     */
    TaskContentDTO<SubTaskShowV0> showTaskContent(String taskId);

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
     * @param taskId 任务id
     * @author FanJane
     */
    void removeTask(String taskId);

    /**
     * 对任务状态进行更新操作
     *
     * @param taskId         要更新状态的任务id
     * @param taskStatusIdGo 要更新到的目标状态
     */
    void updateTaskStatus(String taskId, String taskStatusIdGo);

    /**
     * // Jane_TODO add description
     *
     * @param taskVO 任务表单
     * @return 任务预览
     * @author FanJane
     */
    TaskContentDTO<SubTaskShowV0> getTaskPreview(TaskVO taskVO) ;

    /**
     * // Jane_TODO add description
     *
     * @param taskId 任务id
     * @return 任务列表
     * @author FanJane
     */
    TaskContentDTO<SubTaskUpdateV0> getUpdateTask(String taskId);

    /**
     * 存储任务领取时间
     *
     * @param taskId          任务id
     * @param taskReceiveTime 任务领取时间
     */
    void updateReceiveTime(String taskId, String taskReceiveTime);

    /**
     * 存储巡检完成时间
     *
     * @param taskId         任务id
     * @param taskFinishTime 巡检完成时间
     */
    void updateFinishTime(String taskId, String taskFinishTime);
    /**
     * // Jane_TODO add description
     *
     * @param taskId 任务id
     * @return Jane_TODO 2022/3/18
     * @author FanJane
     */
    TaskContentDTO getWaitReviewTask(String taskId);

    /**
     * // Jane_TODO add description
     *
     * @param taskId
     * @return java.util.List<com.dicadut.soms.dto.InspectorDTO>
     * @author FanJane
     */
    TaskContentDTO getTaskRecord(String taskId);

    /**
     * 根据任务id获得该任务审核意见（其他意见）
     * @param taskId 任务id
     * @return 该任务审核意见
     */
    TaskReviewOpinionDTO getTaskReviewOpinion(String taskId);

    /**
     * // Jane_TODO add description
     *
     * @param taskVO
     * @return void
     * @author FanJane
     */
    void submitUpdateTask(TaskVO taskVO);

    TaskDetailAppVO getTaskDetailApp(String taskId);

    /**
     * // Jane_TODO add description
     * @author FanJane
     * @param opinionVO
     * @return void
     */
    void rejectTask(OpinionVO opinionVO);

    /**
     * // Jane_TODO add description
     * @author FanJane
     * @param taskRecordIdVO
     * @return com.dicadut.soms.vo.TaskDiseaseReviewVO
     */
    TaskDiseaseReviewVO getDiseaseDetail(TaskRecordIdVO taskRecordIdVO);

    /**
     * 根据task_id获得任务状态值
     * @param taskId 任务id
     * @return 任务状态
     */
    TaskStatusDTO getTaskStatus(String taskId);
/**
 * // Jane_TODO add description
 * @author FanJane
 * @param taskId
 * @return void
 */
    void endTask(String taskId);
/**
 * // Jane_TODO add description
 * @author FanJane
 * @param taskId
 * @return void
 */
    void redistributeTask(String taskId);

    /**
     * // Jane_TODO add description
     * @author FanJane
     * @param taskId
     * @param  value
     * @return void
     */
    void passTask(String taskId);
}
