package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.UserStatusDTO;
import com.dicadut.soms.entity.Task;
import com.dicadut.soms.entity.User;
import com.dicadut.soms.mapper.UserMapper;
import com.dicadut.soms.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang
 * @Description TODO
 * @create 2021-10-12 13:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public List<UserStatusDTO> getStatusMaintainerList() {

        QueryWrapper<Task> wrapper = new QueryWrapper<>();
        wrapper.eq("task_status",1002000003 );

        List<Task> tasks = baseMapper.selectList(wrapper);
        List<TaskDisplayDTO> taskDisplayDTOS = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            TaskDisplayDTO taskDisplayDTO = new TaskDisplayDTO();
            BeanUtils.copyProperties(task, taskDisplayDTO);//需要类型也一致吗
            taskDisplayDTOS.add(taskDisplayDTO);



        }
        return taskDisplayDTOS;

    }
}
