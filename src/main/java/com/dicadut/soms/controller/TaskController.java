package com.dicadut.soms.controller;


import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.entity.Task;
import com.dicadut.soms.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 16:42
 */
@Api(tags = "任务管理接口")
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {
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



    @ApiOperation("查询任务状态数量")
    @GetMapping("getTaskStatus")
    public ResponseViewModel<List<TaskDTO>> getTaskStatusLatestList() {
        List<TaskDTO> taskStatusLatestList = taskService.getTaskStatusLatestList();
        return ResponseViewModel.ok(taskStatusLatestList);

    }
}
