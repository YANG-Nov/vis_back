package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.dto.UserDTO;
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

        //查询task_status中最大值
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.orderByAsc("status").last("limit 1");
        User user1 = baseMapper.selectOne(queryWrapper1);
        Integer userStatusMinimum = user1.getStatus();

        //查询task_status中最小值
        QueryWrapper<User> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.orderByDesc("status").last("limit 1");
        User user2 = baseMapper.selectOne(queryWrapper2);
        Integer userStatusMaximum = user2.getStatus();
        //创建list集合
        List<UserStatusDTO> list = new ArrayList<>();

        //遍历每个属性（最小数字和最大数字之间），并查到属性个数，并放入集合）
        for (int i = userStatusMinimum; i < userStatusMaximum + 1; i++) {
            //获得taskstatus为i的任务竖向
            QueryWrapper<User> queryWrapper3 = new QueryWrapper<>();
            queryWrapper3.eq("duty",3).eq("status", i);
            int value = count(queryWrapper3);
            //把任务数量和任务名称封装到对象里
            UserStatusDTO userStatusDTO = new UserStatusDTO();
            userStatusDTO.setValue(value);
            userStatusDTO.setName(i);
            //把对象封装到集合里
            list.add(userStatusDTO);


        }


        return list;


    }
}
