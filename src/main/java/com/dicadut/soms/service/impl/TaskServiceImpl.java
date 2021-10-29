package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.entity.Task;
import com.dicadut.soms.mapper.TaskMapper;
import com.dicadut.soms.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:38
 */
@Slf4j
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
    @Override
    public List<TaskDTO> getTaskStatusLatestList() {
        //查询task_status中最大值
        QueryWrapper<Task> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.orderByAsc("task_status").last("limit 1");
        Task task1 = baseMapper.selectOne(queryWrapper1);
        Integer taskStatusMinimum = task1.getTaskStatus();

        //查询task_status中最小值
        QueryWrapper<Task> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.orderByDesc("task_status").last("limit 1");
        Task task2 = baseMapper.selectOne(queryWrapper2);
        Integer taskStatusMaximum = task2.getTaskStatus();
        //创建list集合
        List<TaskDTO> list = new ArrayList<>();

        //遍历每个属性（最小数字和最大数字之间），并查到属性个数，并放入集合）
        for (int i = taskStatusMinimum; i < taskStatusMaximum + 1; i++) {
            //获得taskstatus为i的任务竖向
            QueryWrapper<Task> queryWrapper3 = new QueryWrapper<>();
            queryWrapper3.eq("task_status", i);
            int value = count(queryWrapper3);
            //把任务数量和任务名称封装到对象里
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setValue(value);
            taskDTO.setName(i);
            //把对象封装到集合里
            list.add(taskDTO);


        }


        return list;


    }
}
