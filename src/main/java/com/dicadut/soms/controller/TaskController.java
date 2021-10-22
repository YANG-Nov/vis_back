package com.dicadut.soms.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.StrainResDTO;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.service.TaskService;
import io.swagger.annotations.Api;
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
    @Autowired
    private TaskService taskSerivce;

    //查询任务状态数量
    @GetMapping("getTaskDataNumber")
    public ResponseViewModel<List<TaskDTO>> getTaskNumberLatestList() {
        return ResponseViewModel.ok(taskSerivce.getTaskNumberLatestList());

    }
}
