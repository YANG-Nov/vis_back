package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.dto.WyResDTO;
import com.dicadut.soms.entity.Task;
import com.dicadut.soms.entity.User;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:37
 */
public interface TaskService extends IService<Task> {

    List<TaskDTO> getTaskStatusLatestList();
}
