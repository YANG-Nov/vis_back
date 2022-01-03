package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.dto.TaskNumDTO;
import com.dicadut.soms.dto.TaskDisplayDTO;
import com.dicadut.soms.dto.TaskStatisticDTO;
import com.dicadut.soms.entity.Task;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:37
 */
public interface TaskService extends IService<Task> {

    List<TaskDTO> getTaskStatusLatestList();

    List<TaskNumDTO> getTaskNumList();

    List<TaskDisplayDTO> getTotalTaskList();

    List<TaskDisplayDTO> getUnclaimedTaskList();

    List<TaskDisplayDTO> getAreInspectionTaskList();

    List<TaskDisplayDTO> getCompletedTaskList();

    TaskStatisticDTO getThisYearTaskList(String startTime, String endTime);

    TaskStatisticDTO getThisYearTaskListByMultiSql(String startTime, String endTime);

    TaskStatisticDTO getThisYearTaskListBySingleSql(String startTime, String endTime);
}