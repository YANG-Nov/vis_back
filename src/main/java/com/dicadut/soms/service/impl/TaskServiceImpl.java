package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.entity.Strain;
import com.dicadut.soms.entity.Task;
import com.dicadut.soms.entity.Wy;
import com.dicadut.soms.mapper.TaskMapper;
import com.dicadut.soms.mapper.WyMapper;
import com.dicadut.soms.service.TaskService;
import com.dicadut.soms.service.WyService;
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
    public List<TaskDTO> getTaskNumberLatestList() {

        //创建list集合封装数据
        List<TaskDTO> taskStatusList = new ArrayList<>();
        //查询表内最小数字和最大数字
        //遍历每个属性（最小数字和最大数字之间），并查到属性个数，并放入集合）相当于课程重的登记
        //QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
       // queryWrapper.eq("task_status", taskStatus);
        //int statusNumber = count(queryWrapper);
        //创建对象封装到对象里
        //放入集合里

        return taskStatusList;


    }
}
