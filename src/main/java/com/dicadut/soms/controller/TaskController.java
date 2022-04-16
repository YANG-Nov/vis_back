package com.dicadut.soms.controller;


import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.enumeration.TaskStatusEnum;
import com.dicadut.soms.exception.TaskException;
import com.dicadut.soms.service.TaskService;
import com.dicadut.soms.viewmodel.PageParam;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import com.dicadut.soms.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @create 2021-10-22 16:42
 */
@Api(tags = "任务接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    /**
     * @author fan_jane
     */
    @ApiOperation("测试功能，查询表中所有数据")
    @GetMapping("find_all")
    @Deprecated
    public List<Task> findAllTask() {
        //调用service的方法实现查询所有的操作返回list集合，方法名称可能和mapper不一样，但是内容都一样
        List<Task> list = taskService.list(null);
        return list;
    }

    /**
     * 选择完构件后，点击确认添加，将任务和任务构件信息传输到数据库存储
     * 前端传过来两级对象，第一级为任务信息，第二级为子任务构信息集合
     *
     * @param taskVO 添加的任务信息
     * @return //暂时没有 Jane_TODO 2022/2/24 后期需要优化
     * @author FanJane
     */
    @ApiOperation(value = "添加任务", tags = {"web", "任务制定页", "jane", "已通"}
            , notes = "选择完构件后，点击确认添加，将任务和任务构件信息传输到数据库存储,createBy:'1483437418882392065'")
    @PostMapping("/add_task")
    public ResponseViewModel addTask(@RequestBody TaskVO taskVO) {

        taskService.saveTask(taskVO);
        return ResponseViewModel.ok();
    }


    /**
     * // Jane_TODO add description
     *
     * @param taskId 当前任务id
     * @return com.dicadut.soms.viewmodel.ResponseViewModel<com.dicadut.soms.dto.TaskContentDTO>
     * @author FanJane
     */
    @ApiOperation(value = "修改任务回显", tags = {"web", "任务列表页", "jane", "已通"}
            , notes = "点击修改任务任务回显")
    @PostMapping("/update_task/{taskId}")
    public ResponseViewModel<TaskContentDTO<SubTaskUpdateV0>> updateTask(@PathVariable String taskId) {
        TaskContentDTO<SubTaskUpdateV0> taskContentDTO = taskService.getUpdateTask(taskId);
        return ResponseViewModel.ok(taskContentDTO);

    }

    /**
     * // Jane_TODO add description
     *
     * @param
     * @return com.dicadut.soms.viewmodel.ResponseViewModel<com.dicadut.soms.dto.TaskContentDTO < com.dicadut.soms.vo.SubTaskUpdateV0>>
     * @author FanJane
     */
    @ApiOperation(value = "提交修改的任务", tags = {"web", "任务列表页", "jane", "未通"}
            , notes = "任务回显，点提交传到后端")
    @PostMapping("/submit_update_task")
    public ResponseViewModel<TaskContentDTO<SubTaskUpdateV0>> submit_UpdateTask(@RequestBody TaskVO taskVO) {
        taskService.submitUpdateTask(taskVO);
        return ResponseViewModel.ok();

    }

    /**
     * // Jane_TODO add description
     *
     * @param taskVO 提交任务表单
     * @return com.dicadut.soms.viewmodel.ResponseViewModel<com.dicadut.soms.dto.TaskContentDTO>
     * @author FanJane
     */
    @ApiOperation(value = "任务预览", tags = {"web", "任务制定页", "jane", "已通"}
            , notes = "选择完构件后，点击确认添加,将前端传过来的表单封装后再传给前端进行弹窗显示,createBy:'1483437418882392065'")
    @PostMapping("/show_task_preview")
    public ResponseViewModel<TaskContentDTO<SubTaskShowV0>> showTaskPreview(@RequestBody TaskVO taskVO) {
        if (CollectionUtils.isEmpty(taskVO.getSubTasks())) {
            throw new TaskException(20001, "添加失败，缺少构件");
        }
        TaskContentDTO<SubTaskShowV0> taskPreview = taskService.getTaskPreview(taskVO);
        return ResponseViewModel.ok(taskPreview);
    }


    @ApiOperation("查询任务状态数量，扇形图")
    @GetMapping("getTaskStatus")
    @Deprecated
    public ResponseViewModel<List<TaskDTO>> getTaskStatusLatestList() {
        List<TaskDTO> taskStatusLatestList = taskService.getTaskStatusLatestList();
        return ResponseViewModel.ok(taskStatusLatestList);
    }

/*    @ApiOperation(("查询任务次数，柱状图"))
    @GetMapping("getTaskNum")
    public ResponseViewModel<List<TaskNumDTO>> getTaskNumList(){
        List<TaskNumDTO> taskNumList = taskService.getTaskNumList();
        return ResponseViewModel.ok(taskNumList);
    }*/


    /**
     * 添加完任务之后，跳转到任务列表页，显示需要修改分配的任务
     * 前端传过来查询条件对象，返回带分页的任务列表
     *
     * @param pageParam 带分页的对象
     * @return 带分页的任务列表
     * @author fan_jane
     */
    @ApiOperation(value = "显示任务列表", tags = {"web", "任务列表页", "jane", "已通"}
            , notes = "制定任务页列表(待分配1002000004,自动召回1002000007，主动召回1002000008)，任务管理页列表taskStatus(总列表 managing_id 1004000002 待领取 wait_receive 1002000001" +
            ", 正在巡检 inspecting 1002000002，待巡检 1002000009 ，任务审核 1003000001(待重传1002000005 待重审1002000010 待审核1002000003)） 记录任务页列表taskStatus（巡检记录 FINISH 1002000006）")
    @PostMapping("/get_task_list")
    public ResponseViewModel<PageResult<TaskSetDTO>> getTaskList(
            @RequestBody(required = false) PageParam<TaskQueryVO> pageParam) {
        return ResponseViewModel.ok(taskService.getTaskList(pageParam.getPageNo(), pageParam.getPageSize()
                , pageParam.getParam()));
    }


    /**
     * 在添加完任务之后跳转的到任务列表例，点击查看按钮，查看该行任务详情
     * 前端传过来当前行的任务id，
     *
     * @param taskId 当前任务id
     * @return 返回二级任务列表，一级为巡检位置，二级为构件
     * @author FanJane
     */
    @ApiOperation(value = "任务列表点查看按钮", tags = {"web", "任务列表页", "jane", "已通"}
            , notes = "在添加完任务之后跳转的到任务列表例，点击查看按钮，查看该行任务详情，测试任务id：20220119000001")
    @GetMapping("/show_task_content/{taskId}")
    public ResponseViewModel<TaskContentDTO<SubTaskShowV0>> getTaskContent(@PathVariable String taskId) {
        TaskContentDTO<SubTaskShowV0> taskContentDTO = taskService.showTaskContent(taskId);
        return ResponseViewModel.ok(taskContentDTO);

    }

    /**
     * 选择巡检范围后弹出所有打卡位置，并默认勾选构件包含的打卡位置
     *
     * @param inspectionScopeVO 巡检范围起始桩号
     * @return CheckBox <ScanPositionDTO> 显示打卡位置
     * @author FanJane
     */
    @ApiOperation(value = "显示打卡位置", tags = {"web", "任务制定页", "jane", "已通"}
            , notes = "选择巡检范围后弹出所有打卡位置，并默认勾选构件包含的打卡位置,巡检范围测试12000~12016")
    @PostMapping("get_scan_position")
    public ResponseViewModel<CheckBox<ScanPositionDTO>> getScanPosition(@RequestBody InspectionScopeVO inspectionScopeVO) {
        CheckBox<ScanPositionDTO> checkBox = taskService.getTaskScanPosition(inspectionScopeVO);
        return ResponseViewModel.ok(checkBox);
    }

    /**
     * // Jane_TODO add description考虑事物吗
     *
     * @param taskId 删除此任务的id
     * @return com.dicadut.soms.viewmodel.ResponseViewModel
     * @author FanJane
     */
    @ApiOperation(value = "删除任务", tags = {"web", "任务列表页", "jane", "未通"})
    @DeleteMapping("/remove_task/{taskId}")
    public ResponseViewModel removeTask(@PathVariable String taskId) {
        taskService.removeTask(taskId);
        return ResponseViewModel.ok();
    }


    /**
     * @author fan_jane
     */
    @ApiOperation("待领取任务列表")
    @GetMapping("get_unclaimed_task_list")
    @Deprecated
    public ResponseViewModel<List<TaskDisplayDTO>> getUnclaimedTaskList() {
        List<TaskDisplayDTO> unclaimedTaskList = taskService.getUnclaimedTaskList();
        return ResponseViewModel.ok(unclaimedTaskList);

    }

    /**
     * @author fan_jane
     */
    @ApiOperation("正在巡检任务列表")
    @GetMapping("get_are_inspection_taskList")
    @Deprecated
    public ResponseViewModel<List<TaskDisplayDTO>> getAreInspectionTaskList() {
        List<TaskDisplayDTO> areInspectionTaskList = taskService.getAreInspectionTaskList();
        return ResponseViewModel.ok(areInspectionTaskList);

    }

    /**
     * @author fan_jane
     */
    @ApiOperation("巡检完成任务列表")
    @GetMapping("get_completed_task_list")
    @Deprecated
    public ResponseViewModel<List<TaskDisplayDTO>> getCompletedTaskList() {
        List<TaskDisplayDTO> completedTaskList = taskService.getCompletedTaskList();
        return ResponseViewModel.ok(completedTaskList);

    }


    @ApiOperation("巡检任务扇形图")
    @GetMapping("get_task_statistic")
    public ResponseViewModel<TaskStatisticDTO> getThisYearTaskListBySingleSql(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseViewModel.ok(taskService.getThisYearTaskListBySingleSql(startTime, endTime));
    }

    @ApiOperation(value = "本月巡检任务统计，APP首页", tags = {"App", "YANG", "App已通"})
    @GetMapping("get_task_statistic_App")
    public ResponseViewModel<TaskStatisticAppDTO> getThisMonthTaskListBySingleSql(@RequestParam String startTime, @RequestParam String endTime, @RequestParam String userId) {
        return ResponseViewModel.ok(taskService.getThisMonthTaskListBySingleSql(startTime, endTime, userId));
    }


    /**
     * Jane_TODO 2022/2/24 是不是要写到user controller里
     * 任务列表点击任务分配获取所有巡检人员，不需要传参，返回人员表和任务表里的相关字段
     *
     * @return 带层级结构的人员列表，一级是人员信息，二级是对应的任务信息
     * @author fan_jane
     */
    @ApiOperation(value = "任务分配获取所有巡检人员", tags = {"web", "任务列表页", "jane", "未通"}
            , notes = "添加完任务后，跳转到任务列表页面，进行任务人员分配")
    @GetMapping("/get_inspector_list")
    public ResponseViewModel<List<InspectorTaskDTO>> getInspectorList() throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<InspectorTaskDTO> taskUserDistributeList = taskService.getInspectorList();
        return ResponseViewModel.ok(taskUserDistributeList);
    }

    /**
     * Jane_TODO 2022/2/24 这个接口前端还没写可以修改传参路径
     * 添加完任务后，跳转到任务列表页面，进行任务人员分配
     * 前端穿过来当前任务id和人员id，后端修改任务表里的人员字段和任务状态字段
     *
     * @param taskId 任务id
     * @param userId 巡检员id
     * @return 无
     * @author fan_jane
     */
    @ApiOperation(value = "任务制定页点击人员分配分配任务", tags = {"web", "任务列表页", "jane", "已通"}
            , notes = "添加完任务后，跳转到任务列表页面，进行任务人员分配")
    @GetMapping("distribute_task/{taskId}/{userId}")
    public ResponseViewModel distributeTask(@PathVariable String taskId, @PathVariable String userId) {
        taskService.distributeTask(taskId, userId);
        return ResponseViewModel.ok();
    }

    @ApiOperation(value = "App任务列表", tags = {"App", "YANG", "App已通"})
    @GetMapping("get_task_app_list")
    public ResponseViewModel<List<TaskAppListDTO>> getTaskAppList(@RequestParam Integer taskStatus, @RequestParam String userId) {
        List<TaskAppListDTO> taskAppList = taskService.getTaskAppList(taskStatus, userId);
        return ResponseViewModel.ok(taskAppList);
    }

    @ApiOperation(value = "App任务对应的打卡点", tags = {"App", "YANG", "App已通"})
    @GetMapping("get_task_scan_position_app_list")
    public ResponseViewModel<List<TaskScanPositionAppListDTO>> getTaskScanPositionAppList(@RequestParam String taskId) {
        List<TaskScanPositionAppListDTO> taskScanPositionAppList = taskService.getTaskScanPositionAppList(taskId);
        return ResponseViewModel.ok(taskScanPositionAppList);
    }


    /**
     * 对任务状态进行更新操作
     *
     * @param taskStatusVO 任务状态任务id
     * @return responseViewModel
     */
    @ApiOperation(value = "更新任务状态", tags = {"App", "YANG", "App已通", "web", "未通"}
            , notes = "变更任务状态，taskId 20220119000001 , taskStatusIdGo 召回（主动）  1002000008  " +
            "1002000001待领取，1002000002正在巡检，1002000003待审核，1002000004待分配，1002000005待重传，1002000006巡检完成，1002000007自动召回，1002000008主动召回，1002000009待巡检，1002000010待重审")
    @PostMapping("/update_task_status")
    public ResponseViewModel updateTaskStatus(@RequestBody TaskStatusVO taskStatusVO) {
        taskService.updateTaskStatus(taskStatusVO.getTaskId(), taskStatusVO.getTaskStatusIdGo());
        return ResponseViewModel.ok();
    }

    @ApiOperation(value = "添加任务领取时间", tags = {"App", "YANG", "App已通"})
    @PostMapping("update_receive_time")
    public ResponseViewModel updateReceiveTime(@RequestBody TaskReceiveTimeVO taskReceiveTimeVO) {
        taskService.updateReceiveTime(taskReceiveTimeVO.getTaskId(), taskReceiveTimeVO.getTaskReceiveTime());
        return ResponseViewModel.ok();
    }

    @ApiOperation(value = "添加巡检完成时间", tags = {"App", "YANG", "App已通"})
    @PostMapping("update_finish_time")
    public ResponseViewModel updateFinishTime(@RequestBody TaskFinishTimeVO taskFinishTimeVO) {
        taskService.updateFinishTime(taskFinishTimeVO.getTaskId(), taskFinishTimeVO.getTaskFinishTime());
        return ResponseViewModel.ok();
    }


    /**
     * //
     *
     * @param taskId
     * @return com.dicadut.soms.viewmodel.ResponseViewModel<java.util.List < com.dicadut.soms.dto.InspectorDTO>>
     * @author FanJane
     */
    @ApiOperation(value = "获得待审核任务表单", tags = {"web", "任务列表页", "jane", "未通"}
            , notes = "点审核获得任务和病害信息测试任务id20220401000001")
    @GetMapping("/get_wait_review_task/{taskId}")

    public ResponseViewModel<TaskContentDTO> getWaitReviewTask(@PathVariable String taskId) {
        TaskContentDTO taskUserDistributeList = taskService.getWaitReviewTask(taskId);
        return ResponseViewModel.ok(taskUserDistributeList);
    }
    /**
     * //
     *
     * @param taskRecordIdVO
     * @return com.dicadut.soms.viewmodel.ResponseViewModel<java.util.List < com.dicadut.soms.dto.InspectorDTO>>
     * @author FanJane
     */
    @ApiOperation(value = "获得一条任务的病害信息", tags = {"web", "任务列表页", "jane", "未通"}
            , notes = "任务：id20220320000004，记录id：2")
    @PostMapping("/get_disease_detail")

    public ResponseViewModel<TaskDiseaseReviewVO> getDiseaseDetail(@RequestBody TaskRecordIdVO taskRecordIdVO) {
        TaskDiseaseReviewVO taskDiseaseReviewVO = taskService.getDiseaseDetail(taskRecordIdVO);
        return ResponseViewModel.ok(taskDiseaseReviewVO);
    }

    /**
     * // Jane_TODO add description
     *
     * @param taskId 任务id
     * @return
     * @author FanJane
     */
    @ApiOperation(value = "获得任务记录", tags = {"web", "巡检记录页", "jane", "未通"}
            , notes = "巡检记录页点查看获得任务以及病害记录")
    @GetMapping("/get_task_record/{taskId}")
    public ResponseViewModel<TaskContentDTO> getTaskRecord(@PathVariable String taskId) {
        TaskContentDTO taskUserDistributeList = taskService.getTaskRecord(taskId);
        return ResponseViewModel.ok(taskUserDistributeList);
    }

    /**
     * 根据任务id获得该任务审核意见（其他意见）
     *
     * @param taskId 任务id
     * @return 该任务审核意见
     */
    @ApiOperation(value = "根据任务id获得该任务审核意见（其他意见）", tags = {"App", "YANG", "App已通"})
    @GetMapping("get_task_review_opinion")
    public ResponseViewModel<TaskReviewOpinionDTO> getTaskReviewOpinion(@RequestParam String taskId) {
        TaskReviewOpinionDTO taskReviewOpinionDTO = taskService.getTaskReviewOpinion(taskId);
        return ResponseViewModel.ok(taskReviewOpinionDTO);
    }

    /**
     * 根据任务id获得该任务详情（移动端）
     * @param taskId 任务id
     * @return 该任务详情
     */
    @ApiOperation(value = "根据任务id获得该任务详情（移动端）", tags = {"App", "YANG", "App未通"})
    @GetMapping("get_task_details_app")
    public ResponseViewModel<TaskDetailAppVO> getTaskDetailApp(@RequestParam String taskId) {
        TaskDetailAppVO taskDetailAppVO = taskService.getTaskDetailApp(taskId);
        return ResponseViewModel.ok(taskDetailAppVO);
    }

    @ApiOperation(value = "通过任务审核", tags = {"web", "任务列表页", "jane", "未通"}
            , notes = "没有返回建议通过任务审核")
    @GetMapping("/pass/{taskId}")

    public ResponseViewModel passTask(@PathVariable String taskId) {
        taskService.passTask(taskId);
        return ResponseViewModel.ok();
    }

    @ApiOperation(value = "召回任务", tags = {"web", "任务列表页", "jane", "未通"}
            , notes = "召回")
    @GetMapping("/recall/{taskId}")

    public ResponseViewModel recallTask(@PathVariable String taskId) {
        taskService.updateTaskStatus(taskId, TaskStatusEnum.MAN_RECALL.getValue());
        return ResponseViewModel.ok();
    }

    @ApiOperation(value = "退回任务", tags = {"web", "任务列表页", "jane", "未通"}
            , notes = "没有返回建议通过任务审核")
    @PostMapping("/reject")
    public ResponseViewModel<TaskContentDTO> rejectTask(@RequestBody OpinionVO opinionVO) {
        if (CollectionUtils.isEmpty(opinionVO.getReviewOpinions())) {
            throw new TaskException(20001, "添加失败，审核意见");
        }
        taskService.rejectTask(opinionVO);
        return ResponseViewModel.ok();
    }

    /**
     * 根据任务id获得该任务状态值
     * @param taskId 任务id
     * @return 任务状态
     */
    @ApiOperation(value = "根据任务id获得该任务状态值", tags = {"App", "YANG", "App已通"})
    @GetMapping("get_task_status")
    public ResponseViewModel<TaskStatusDTO> getTaskStatus(@RequestParam String taskId) {
        TaskStatusDTO taskStatusDTO = taskService.getTaskStatus(taskId);
        return ResponseViewModel.ok(taskStatusDTO);
    }

    @ApiOperation(value = "任务制定页终止任务", tags = {"web", "任务制定页", "jane", "未通"}
            , notes = "终止召回和自动召回的任务id20220415000001")
    @GetMapping("/end_task/{taskId}")

    public ResponseViewModel endTask(@PathVariable String taskId) {
        taskService.endTask(taskId);
        return ResponseViewModel.ok();
    }

    @ApiOperation(value = "任务制定页再分配任务", tags = {"web", "任务制定页", "jane", "未通"}
            , notes = "终止召回和自动召回的任务id20220415000001")
    @GetMapping("/redistribute_task/{taskId}")

    public ResponseViewModel redistributeTask(@PathVariable String taskId) {
        taskService.redistributeTask(taskId);
        return ResponseViewModel.ok();
    }
}
