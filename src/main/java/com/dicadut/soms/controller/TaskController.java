package com.dicadut.soms.controller;


import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.entity.Task;
import com.dicadut.soms.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-22 16:42
 */
@Api(tags = "任务管理接口")
@Slf4j
@RestController
@RequestMapping("/task")
public class  TaskController {
    //访问地址 ：http://localhost:8089/task/findAll
    //注入service
    @Autowired
    private TaskService taskService;


    @ApiOperation("测试功能，查询表中所有数据")
    @GetMapping("findAll")
    public List<Task> findAllTask(){
        //调用service的方法实现查询所有的操作返回list集合，方法名称可能和mapper不一样，但是内容都一样
        List<Task> list = taskService.list(null);
        return list;
    }



    @ApiOperation("查询任务状态数量，扇形图")
    @GetMapping("getTaskStatus")
    public ResponseViewModel<List<TaskDTO>> getTaskStatusLatestList() {
        List<TaskDTO> taskStatusLatestList = taskService.getTaskStatusLatestList();
        return ResponseViewModel.ok(taskStatusLatestList);

    }

    @ApiOperation(("查询任务次数，柱状图"))
    @GetMapping("getTaskNum")
    public ResponseViewModel<List<TaskNumDTO>> getTaskNumList(){
        List<TaskNumDTO> taskNumList = taskService.getTaskNumList();
        return ResponseViewModel.ok(taskNumList);
    }

    @ApiOperation("总任务列表")
    @GetMapping("getTotalTaskList")
    public ResponseViewModel<List<TaskDisplayDTO>> getTotalTaskList(){
        List<TaskDisplayDTO> totalTaskList = taskService.getTotalTaskList();
        return ResponseViewModel.ok(totalTaskList);

    }

    @ApiOperation("待领取任务列表")
    @GetMapping("getUnclaimedTaskList")
    public ResponseViewModel<List<TaskDisplayDTO>> getUnclaimedTaskList(){
        List<TaskDisplayDTO> unclaimedTaskList = taskService.getUnclaimedTaskList();
        return ResponseViewModel.ok(unclaimedTaskList);

    }

    @ApiOperation("正在巡检任务列表")
    @GetMapping("getAreInspectionTaskList")
    public ResponseViewModel<List<TaskDisplayDTO>> getAreInspectionTaskList(){
        List<TaskDisplayDTO> areInspectionTaskList = taskService.getAreInspectionTaskList();
        return ResponseViewModel.ok(areInspectionTaskList);

    }

    @ApiOperation("巡检完成任务列表")
    @GetMapping("getCompletedTaskList")
    public ResponseViewModel<List<TaskDisplayDTO>> getCompletedTaskList(){
        List<TaskDisplayDTO> completedTaskList = taskService.getCompletedTaskList();
        return ResponseViewModel.ok(completedTaskList);

    }

    @ApiOperation("添加任务")
    @PostMapping("addTask")
    public ResponseViewModel addTask(@RequestBody Task task){
        boolean save = taskService.save(task);
        if (save){
            return ResponseViewModel.ok();
        }else{
            return ResponseViewModel.fail("添加失败");
        }

    }

    @ApiOperation("本年度巡检任务列表")
    @GetMapping("getThisYearTaskListBySingleSql")
    public ResponseViewModel<TaskStatisticDTO> getThisYearTaskListBySingleSql(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseViewModel.ok(taskService.getThisYearTaskListBySingleSql(startTime, endTime));
    }

    @ApiOperation("本月巡检任务列表，APP")
    @GetMapping("getThisMonthTaskListBySingleSql")
    public ResponseViewModel<TaskStatisticAppDTO> getThisMonthTaskListBySingleSql(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseViewModel.ok(taskService.getThisMonthTaskListBySingleSql(startTime, endTime));
    }
}
