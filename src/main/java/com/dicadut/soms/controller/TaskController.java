package com.dicadut.soms.controller;


import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.service.TaskService;
import com.dicadut.soms.viewmodel.PageParam;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.viewmodel.ResponseViewModel;
import com.dicadut.soms.vo.TaskQueryVO;
import com.dicadut.soms.vo.TaskVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-22 16:42
 */
@Api(tags = "任务接口")
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    /**
     * @author fan_jane
     */
    @ApiOperation("测试功能，查询表中所有数据")
    @GetMapping("find_all")
    public List<Task> findAllTask() {
        //调用service的方法实现查询所有的操作返回list集合，方法名称可能和mapper不一样，但是内容都一样
        List<Task> list = taskService.list(null);
        return list;
    }

    /**
     * @author fan_jane
     * 20220118
     */
    @ApiOperation("添加任务")
    @PostMapping("add_ask")
    public ResponseViewModel addTask(@RequestBody TaskVO taskVO) {
        taskService.saveTask(taskVO);
        return ResponseViewModel.ok();
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
     * 分页查询
     *
     * @param pageParam
     * @return
     * @author fan_jane
     */
    @ApiOperation("任务制定页显示任务列表")
    @PostMapping("get_amending_taskList")
    public ResponseViewModel<PageResult<AmendingTaskDTO>> getAmendingTaskList(@RequestBody(required = false) PageParam<TaskQueryVO> pageParam) {
        return ResponseViewModel.ok(taskService.getAmendingTaskList(pageParam.getPageNo(), pageParam.getPageSize(), pageParam.getParam()));
    }

    /**
     * @author fan_jane
     */
    @ApiOperation("任务制定页任务列表点查看按钮")
    @GetMapping("show_taskContent/{taskId}")
    public ResponseViewModel<TaskContentDTO> getTaskContent(@PathVariable String taskId) {
        TaskContentDTO taskContent = taskService.getTaskContent(taskId);
        return ResponseViewModel.ok(taskContent);

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


    @ApiOperation("本年度巡检任务列表")
    @GetMapping("get_this_year_task_list_by_single_sql")    // TODO 接口路径
    public ResponseViewModel<TaskStatisticDTO> getThisYearTaskListBySingleSql(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseViewModel.ok(taskService.getThisYearTaskListBySingleSql(startTime, endTime));
    }

    @ApiOperation("本月巡检任务列表，APP首页")
    @GetMapping("get_this_month_task_list_by_single_sql")   // TODO 接口路径
    public ResponseViewModel<TaskStatisticAppDTO> getThisMonthTaskListBySingleSql(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseViewModel.ok(taskService.getThisMonthTaskListBySingleSql(startTime, endTime));
    }


    /**
     * TODO 是不是要写到user controller里
     *
     * @author fan_jane
     * * 20220118
     */
    @ApiOperation("任务制定页点击任务分配获取所有巡检人员")
    @GetMapping("get_inspector_list")
    public ResponseViewModel<List<InspectorDTO>> getInspectorList() {
        List<InspectorDTO> taskUserDistributeList = taskService.getInspectorList();
        return ResponseViewModel.ok(taskUserDistributeList);
    }

    /**
     * T
     *
     * @author fan_jane
     * * 20220118
     */
    @ApiOperation("任务制定页点击人员分配分配任务")
    @GetMapping("distribute_task/{taskId}/{userId}")
    public ResponseViewModel distributeTask(@PathVariable String taskId, @PathVariable String userId) {
        taskService.distributeTask(taskId, userId);
        return ResponseViewModel.ok();
    }

    @ApiOperation("App任务列表")
    @GetMapping("get_task_app_list")
    public ResponseViewModel<List<TaskAppListDTO>> getTaskAppList(@RequestParam Integer taskStatus, @RequestParam Integer inspectionFrequency) {
        List<TaskAppListDTO> taskAppList = taskService.getTaskAppList(taskStatus, inspectionFrequency);
        return ResponseViewModel.ok(taskAppList);
    }

    @ApiOperation("查看任务信息")
    @GetMapping("getTaskDetails")
    @Deprecated  // TODO 删除
    public ResponseViewModel<TaskDetailsDTO> getTaskDetails(@RequestParam String taskId) {
        return ResponseViewModel.ok(taskService.getTaskDetails(taskId));
    }

    @ApiOperation("App任务对应的打卡点")
    @GetMapping("get_task_scan_position_app_list")
    public ResponseViewModel<List<TaskScanPositionAppListDTO>> getTaskScanPositionAppList(@RequestParam String taskId) {
        List<TaskScanPositionAppListDTO> taskScanPositionAppList = taskService.getTaskScanPositionAppList(taskId);
        return ResponseViewModel.ok(taskScanPositionAppList);
    }
}
