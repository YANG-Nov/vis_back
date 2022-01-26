package com.dicadut.soms.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.AmendingTaskDTO;
import com.dicadut.soms.dto.InspectorDTO;
import com.dicadut.soms.dto.TaskAppListDTO;
import com.dicadut.soms.dto.TaskContentDTO;
import com.dicadut.soms.dto.TaskDTO;
import com.dicadut.soms.dto.TaskDetailsDTO;
import com.dicadut.soms.dto.TaskDisplayDTO;
import com.dicadut.soms.dto.TaskScanPositionAppListDTO;
import com.dicadut.soms.dto.TaskStatisticAppDTO;
import com.dicadut.soms.dto.TaskStatisticDTO;
import com.dicadut.soms.dto.viewmodel.PageResult;
import com.dicadut.soms.enumeration.TaskStatusEnum;
import com.dicadut.soms.mapper.TaskMapper;
import com.dicadut.soms.service.BusinessCodeService;
import com.dicadut.soms.service.TaskService;
import com.dicadut.soms.vo.TaskQueryVO;
import com.dicadut.soms.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:38
 */
@Slf4j
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Resource
    private BusinessCodeService businessCodeService;


    @Override
    public List<TaskDTO> getTaskStatusLatestList() {
        return baseMapper.selectTaskStatusLatestList();
    }

    /**
     * 根据taskStatus获取任务列表， 如taskStatus为null或空串，则获取所有任务列表
     *
     * @param taskStatus 参考 TaskStatusEnum 的定义
     * @return
     */
    private List<TaskDisplayDTO> getTaskDisplayList(String taskStatus) {
        QueryWrapper<Task> wrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(taskStatus)) {
            wrapper.eq("task_status", taskStatus);
        }

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
    public PageResult<AmendingTaskDTO> getAmendingTaskList(Integer currentPage, Integer pageSize, TaskQueryVO taskQueryVO) {
        IPage<AmendingTaskDTO> page = new Page<>(currentPage, pageSize);
        baseMapper.getAmendingTaskListByePageQuery(page, taskQueryVO);
        return PageResult.buildPage(page);
    }

    @Override
    public List<TaskDisplayDTO> getUnclaimedTaskList() {
        return getTaskDisplayList(TaskStatusEnum.WAIT_RECEIVE.getValue());
    }

    @Override
    public List<TaskDisplayDTO> getAreInspectionTaskList() {
        return getTaskDisplayList(TaskStatusEnum.INSPECTING.getValue());
    }

    @Override
    public List<TaskDisplayDTO> getCompletedTaskList() {
        return getTaskDisplayList(TaskStatusEnum.WAIT_REVIEW.getValue());
    }

    /**
     * 法一：
     * 该方法首先将所有本年度的任务都从数据库中读取到内存，然后再在内存中统计各类状态的任务数，对于小数据场景可行，但大数据场景会
     * 导致性能很低下，甚至不可用，后续我再提供一个新的方法做参考
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

    //APP首页报表
    @Override
    public TaskStatisticAppDTO getThisMonthTaskListBySingleSql(String startTime, String endTime) {

        TaskStatisticAppDTO taskStatisticAppDTO = baseMapper.selectTaskStatisticAppByTaskStatus(startTime, endTime);

        double p1 = taskStatisticAppDTO.getFinishCount();
        double p2 = taskStatisticAppDTO.getTotalCount();
        double p3 = p1 / p2;
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(1);
        taskStatisticAppDTO.setFinishPercentage(nf.format(p3));

        return taskStatisticAppDTO;
    }

    @Override
    public List<InspectorDTO> getInspectorList() {
        List<InspectorDTO> inspectorDTOList = baseMapper.selectInspectorList();
        for (InspectorDTO inspectorDTO :
                inspectorDTOList) {
            inspectorDTO.setChildren(baseMapper.selectTaskByInspector(inspectorDTO.getId()));
        }
        return inspectorDTOList;
    }

    //App待确认页面，每日一次
    public List<TaskAppListDTO> getTaskAppList(Integer taskStatus, Integer inspectionFrequency) {
        return baseMapper.selectTaskAppList(taskStatus, inspectionFrequency);
    }

    //查看任务信息
    @Override
    public TaskDetailsDTO getTaskDetails(String taskId) {
        return baseMapper.selectTaskDetails(taskId);
    }


    /**
     * 添加任务的方法
     * 把taskVo添加到task
     * 并设置状态为待分配
     */
    @Override
    public void saveTask(TaskVO taskVO) {
        String taskId = businessCodeService.generateBusinessCode("t_task");
        baseMapper.addTask(taskId, taskVO);
        baseMapper.addTaskComponent(taskId, taskVO.getComponentNumberDTOS());
    }

    /**
     * TODO
     * 巡检内容
     * 添加任务中的巡检人员
     * 并设置状态为待领取
     */
    @Override
    public void distributeTask(String taskId, String userId) {
        baseMapper.addInspectorToTask(taskId, userId);
    }

    /**
     *
     */
    @Override
    public TaskContentDTO getTaskContent(String taskId) {
        TaskContentDTO taskContentDTO = new TaskContentDTO();
        taskContentDTO.setInspectionPosition(baseMapper.getInspectionPosition(taskId));
        taskContentDTO.setChildren(baseMapper.getComponentNumberRange(baseMapper.getComponentList(taskId), taskId));
        return taskContentDTO;
    }

    @Override
    public List<TaskScanPositionAppListDTO> getTaskScanPositionAppList(String taskId) {
        return baseMapper.selectTaskScanPositionAppList(taskId);
    }

}
