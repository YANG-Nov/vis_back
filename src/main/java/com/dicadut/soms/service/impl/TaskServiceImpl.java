package com.dicadut.soms.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.dto.TaskDisplayDTO;
import com.dicadut.soms.dto.TaskNumDTO;
import com.dicadut.soms.dto.TaskStatisticDTO;
import com.dicadut.soms.entity.Task;
import com.dicadut.soms.enumeration.TaskStatusEnum;
import com.dicadut.soms.mapper.TaskMapper;
import com.dicadut.soms.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:38
 */
@Slf4j
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    //查询任务状态数量，扇形图
    @Override
    public List<TaskDTO> getTaskStatusLatestList() {
        //查询task_status中最大值
        QueryWrapper<Task> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.orderByAsc("task_status").last("limit 1");
        Task task1 = baseMapper.selectOne(queryWrapper1);
        Integer taskStatusMinimum = Integer.valueOf(task1.getTaskStatus());

        //查询task_status中最小值
        QueryWrapper<Task> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.orderByDesc("task_status").last("limit 1");
        Task task2 = baseMapper.selectOne(queryWrapper2);
        Integer taskStatusMaximum = Integer.valueOf(task2.getTaskStatus());
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

    //查询任务次数，柱状图
    @Override
    public List<TaskNumDTO> getTaskNumList() {
        //查询巡检次数
        List<TaskNumDTO> taskNum = new ArrayList<>();
        TaskNumDTO patrolTaskDTO = new TaskNumDTO();
        int[] taskNumArray = new int[12];
        patrolTaskDTO.setName("巡检次数");
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("task_type", 1001000001);
        List<Task> tasks = baseMapper.selectList(queryWrapper);
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            Date createTime = task.getCreateTime();
            Calendar c = Calendar.getInstance();
            c.setTime(createTime);
            int month = c.get(Calendar.MONTH);
            switch (month) {
                case 0:
                    taskNumArray[0]++;
                    break;
                case 1:
                    taskNumArray[1]++;
                    break;
                case 2:
                    taskNumArray[2]++;
                    break;
                case 3:
                    taskNumArray[3]++;
                    break;
                case 4:
                    taskNumArray[4]++;
                    break;
                case 5:
                    taskNumArray[5]++;
                    break;
                case 6:
                    taskNumArray[6]++;
                    break;
                case 7:
                    taskNumArray[7]++;
                    break;
                case 8:
                    taskNumArray[8]++;
                    break;
                case 9:
                    taskNumArray[9]++;
                    break;
                case 10:
                    taskNumArray[10]++;
                    break;
                case 11:
                    taskNumArray[11]++;
                    break;
            }
        }
        patrolTaskDTO.setData(taskNumArray);
        taskNum.add(patrolTaskDTO);
      /*  QueryWrapper<Task> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("task_type", 1001000001 ).between("create_time","2021-01-01","2021-01-31");
        numList.add(count(queryWrapper1));
        QueryWrapper<Task> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("task_type", 1001000001 ).between("create_time","2021-02-01","2021-02-31" );
        numList.add(count(queryWrapper2));
        QueryWrapper<Task> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("task_type", 1001000001 ).between("create_time","2021-03-01","2021-03-31" );
        numList.add(count(queryWrapper3));
        QueryWrapper<Task> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.eq("task_type", 1001000001 ).between("create_time","2021-04-01","2021-04-31" );
        numList.add(count(queryWrapper4));
        QueryWrapper<Task> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.eq("task_type", 1001000001 ).between("create_time","2021-05-01","2021-05-31" );
        numList.add(count(queryWrapper5));
        QueryWrapper<Task> queryWrapper6 = new QueryWrapper<>();
        queryWrapper6.eq("task_type", 1001000001 ).between("create_time","2021-06-01","2021-06-31" );
        numList.add(count(queryWrapper6));
        QueryWrapper<Task> queryWrapper7 = new QueryWrapper<>();
        queryWrapper7.eq("task_type", 1001000001 ).between("create_time","2021-07-01","2021-07-31" );
        numList.add(count(queryWrapper7));
        QueryWrapper<Task> queryWrapper8 = new QueryWrapper<>();
        queryWrapper8.eq("task_type", 1001000001 ).between("create_time","2021-08-01","2021-8-31" );
        numList.add(count(queryWrapper8));
        QueryWrapper<Task> queryWrapper9 = new QueryWrapper<>();
        queryWrapper9.eq("task_type", 1001000001 ).between("create_time","2021-9-01","2021-9-31" );
        numList.add(count(queryWrapper9));
        QueryWrapper<Task> queryWrapper10 = new QueryWrapper<>();
        queryWrapper10.eq("task_type", 1001000001 ).between("create_time","2021-10-01","2021-10-31" );
        numList.add(count(queryWrapper10));
        QueryWrapper<Task> queryWrapper11 = new QueryWrapper<>();
        queryWrapper11.eq("task_type", 1001000001 ).between("create_time","2021-11-01","2021-11-31" );
        numList.add(count(queryWrapper11));
        QueryWrapper<Task> queryWrapper12 = new QueryWrapper<>();
        queryWrapper12.eq("task_type", 1001000001 ).between("create_time","2021-12-01","2021-12-31" );
        numList.add(count(queryWrapper12));
        patrolTaskDTO.setData(numList);*/


        //查询维修次数

        TaskNumDTO maintenanceTaskDTO = new TaskNumDTO();
        int[] maintenanceTaskNumArray = new int[12];
        maintenanceTaskDTO.setName("维修次数");
        QueryWrapper<Task> wrapper = new QueryWrapper<>();
        wrapper.eq("task_type", 1001000004);
        List<Task> maintenanceTasks = baseMapper.selectList(wrapper);
        for (int i = 0; i < tasks.size(); i++) {
            Task maintenanceTask = maintenanceTasks.get(i);
            Date createTime = maintenanceTask.getCreateTime();
            Calendar c = Calendar.getInstance();
            c.setTime(createTime);
            int month = c.get(Calendar.MONTH);
            switch (month) {
                case 0:
                    maintenanceTaskNumArray[0]++;
                    break;
                case 1:
                    maintenanceTaskNumArray[1]++;
                    break;
                case 2:
                    maintenanceTaskNumArray[2]++;
                    break;
                case 3:
                    maintenanceTaskNumArray[3]++;
                    break;
                case 4:
                    maintenanceTaskNumArray[4]++;
                    break;
                case 5:
                    maintenanceTaskNumArray[5]++;
                    break;
                case 6:
                    maintenanceTaskNumArray[6]++;
                    break;
                case 7:
                    maintenanceTaskNumArray[7]++;
                    break;
                case 8:
                    maintenanceTaskNumArray[8]++;
                    break;
                case 9:
                    maintenanceTaskNumArray[9]++;
                    break;
                case 10:
                    maintenanceTaskNumArray[10]++;
                    break;
                case 11:
                    maintenanceTaskNumArray[11]++;
                    break;
            }
        }
        maintenanceTaskDTO.setData(maintenanceTaskNumArray);
        taskNum.add(maintenanceTaskDTO);
        return taskNum;

 /*       TaskNumDTO maintenanceTaskDTO = new TaskNumDTO();
        List<Integer> maintenanceNumList = new ArrayList<>();
        maintenanceTaskDTO.setName("维修次数");
        QueryWrapper<Task> queryWrapper21 = new QueryWrapper<>();
        queryWrapper21.eq("task_type", 1001000004 ).between("create_time","2021-01-01","2021-01-31" );
        maintenanceNumList .add(count(queryWrapper11));
        QueryWrapper<Task> queryWrapper22 = new QueryWrapper<>();
        queryWrapper22.eq("task_type", 1001000004 ).between("create_time","2021-02-01","2021-02-31" );
        maintenanceNumList.add(count(queryWrapper22));
        QueryWrapper<Task> queryWrapper23 = new QueryWrapper<>();
        queryWrapper23.eq("task_type", 1001000004 ).between("create_time","2021-03-01","2021-03-31" );
        maintenanceNumList.add(count(queryWrapper23));
        QueryWrapper<Task> queryWrapper24 = new QueryWrapper<>();
        queryWrapper24.eq("task_type", 1001000004 ).between("create_time","2021-04-01","2021-04-31" );
        maintenanceNumList.add(count(queryWrapper24));
        QueryWrapper<Task> queryWrapper25 = new QueryWrapper<>();
        queryWrapper25.eq("task_type", 1001000004 ).between("create_time","2021-05-01","2021-05-31" );
        maintenanceNumList.add(count(queryWrapper25));
        QueryWrapper<Task> queryWrapper26 = new QueryWrapper<>();
        queryWrapper26.eq("task_type", 1001000004 ).between("create_time","2021-06-01","2021-06-31" );
        maintenanceNumList.add(count(queryWrapper26));
        QueryWrapper<Task> queryWrapper27 = new QueryWrapper<>();
        queryWrapper27.eq("task_type", 1001000004 ).between("create_time","2021-07-01","2021-07-31" );
        maintenanceNumList.add(count(queryWrapper27));
        QueryWrapper<Task> queryWrapper28 = new QueryWrapper<>();
        queryWrapper28.eq("task_type", 1001000004 ).between("create_time","2021-8-01","2021-8-31" );
        maintenanceNumList.add(count(queryWrapper28));
        QueryWrapper<Task> queryWrapper29 = new QueryWrapper<>();
        queryWrapper29.eq("task_type", 1001000004 ).between("create_time","2021-9-01","2021-9-31" );
        maintenanceNumList.add(count(queryWrapper29));
        QueryWrapper<Task> queryWrapper30 = new QueryWrapper<>();
        queryWrapper30.eq("task_type", 1001000004 ).between("create_time","2021-10-01","2021-10-31" );
        maintenanceNumList.add(count(queryWrapper30));
        QueryWrapper<Task> queryWrapper31 = new QueryWrapper<>();
        queryWrapper31.eq("task_type", 1001000004 ).between("create_time","2021-11-01","2021-11-31" );
        maintenanceNumList.add(count(queryWrapper31));
        QueryWrapper<Task> queryWrapper32 = new QueryWrapper<>();
        queryWrapper32.eq("task_type", 1001000004 ).between("create_time","2021-12-01","2021-12-31" );
        maintenanceNumList.add(count(queryWrapper32));
        maintenanceTaskDTO.setData(maintenanceNumList);
        taskNum.add(maintenanceTaskDTO);
        return taskNum;*/
    }

    @Override
    public List<TaskDisplayDTO> getTotalTaskList() {
        List<Task> tasks = baseMapper.selectList(null);
        List<TaskDisplayDTO> taskDisplayDTOS = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            TaskDisplayDTO taskDisplayDTO = new TaskDisplayDTO();
            BeanUtils.copyProperties(task, taskDisplayDTO);//需要类型也一致吗
            taskDisplayDTOS.add(taskDisplayDTO);


        }
        return taskDisplayDTOS;
    }

    @Override
    public List<TaskDisplayDTO> getUnclaimedTaskList() {
        QueryWrapper<Task> wrapper = new QueryWrapper<>();
        wrapper.eq("task_status", 1002000001);

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

    @Override
    public List<TaskDisplayDTO> getAreInspectionTaskList() {
        QueryWrapper<Task> wrapper = new QueryWrapper<>();
        wrapper.eq("task_status", 1002000002);

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

    @Override
    public List<TaskDisplayDTO> getCompletedTaskList() {
        QueryWrapper<Task> wrapper = new QueryWrapper<>();
        wrapper.eq("task_status", 1002000003);

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

    /**
     * 法一：
     * 该方法首先将所有本年度的任务都从数据库中读取到内存，然后再在内存中统计各类状态的任务数，对于小数据场景可行，但大数据场景会导致性能很低下，甚至不可用，后续我再提供一个新的方法做参考
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public TaskStatisticDTO getThisYearTaskList(String startTime, String endTime) {
        startTime = startTime == null ? String.format("%s-01-01 00:00:00", DateUtil.thisYear()) : startTime;
        endTime = endTime == null ? DateUtil.now() : endTime;
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("create_time", startTime, endTime);
        List<Task> tasks = baseMapper.selectList(queryWrapper);

        TaskStatisticDTO taskStatisticDTO = new TaskStatisticDTO();
        taskStatisticDTO.setTotalCount(tasks.size());
        taskStatisticDTO.setWait4ReceivedCount((int) tasks.stream().filter(e -> TaskStatusEnum.WAIT_RECEIVE.getValue().equalsIgnoreCase(e.getTaskStatus())).count());
        taskStatisticDTO.setWait4ReviewedCount((int) tasks.stream().filter(e -> TaskStatusEnum.WAIT_REVIEW.getValue().equalsIgnoreCase(e.getTaskStatus())).count());
        taskStatisticDTO.setWait4RetransmittedCount((int) tasks.stream().filter(e -> TaskStatusEnum.WAIT_RETRANSMIT.getValue().equalsIgnoreCase(e.getTaskStatus())).count());
        taskStatisticDTO.setInspectingCount((int) tasks.stream().filter(e -> TaskStatusEnum.INSPECTING.getValue().equalsIgnoreCase(e.getTaskStatus())).count());

        return taskStatisticDTO;
    }

    /**
     * 法二：
     * 该方法直接通过查数据库进行统计，总共查数据库5次，实现时引入xml配置文件，通过在xml中写sql实现查询功能，请跟进理解和学习。
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public TaskStatisticDTO getThisYearTaskListByMultiSql(String startTime, String endTime) {
        TaskStatisticDTO taskStatisticDTO = new TaskStatisticDTO();
        taskStatisticDTO.setTotalCount(baseMapper.selectCountByTaskStatus(startTime, endTime, null));
        taskStatisticDTO.setWait4ReceivedCount(baseMapper.selectCountByTaskStatus(startTime, endTime, TaskStatusEnum.WAIT_RECEIVE.getValue()));
        taskStatisticDTO.setWait4ReviewedCount(baseMapper.selectCountByTaskStatus(startTime, endTime, TaskStatusEnum.WAIT_REVIEW.getValue()));
        taskStatisticDTO.setWait4RetransmittedCount(baseMapper.selectCountByTaskStatus(startTime, endTime, TaskStatusEnum.WAIT_RETRANSMIT.getValue()));
        taskStatisticDTO.setInspectingCount(baseMapper.selectCountByTaskStatus(startTime, endTime, TaskStatusEnum.INSPECTING.getValue()));
        return taskStatisticDTO;
    }

    /**
     * 法三：
     * 该方法直接通过查数据库进行统计，总共查数据库1次，性能最优。
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public TaskStatisticDTO getThisYearTaskListBySingleSql(String startTime, String endTime) {
        return baseMapper.selectTaskStatisticByTaskStatus(startTime, endTime);
    }
}
