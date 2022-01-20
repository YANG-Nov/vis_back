package com.dicadut.soms.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.dto.viewmodel.PageResult;
import com.dicadut.soms.enumeration.TaskStatusEnum;
import com.dicadut.soms.mapper.TaskMapper;
import com.dicadut.soms.service.BusinessCodeService;
import com.dicadut.soms.service.TaskService;
import com.dicadut.soms.vo.TaskQueryVO;
import com.dicadut.soms.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private BusinessCodeService businessCodeService;


    //查询任务状态数量，扇形图
    @Override
    public List<TaskDTO> getTaskStatusLatestList() {
        return baseMapper.selectTaskStatusLatestList();
    }

    //TODO 查询任务次数，柱状图优化
/*    @Override
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
        taskNum.add(patrolTaskDTO);*/


        //查询维修次数

/*        TaskNumDTO maintenanceTaskDTO = new TaskNumDTO();
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
        return taskNum;*/


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
    /**
     *
     *条件查询分页
     * @param current   第几页
     *  @param size   每页显示数量
     * @param  taskQueryVO 查询条件
     * @return PageResult<AmendingTaskDTO>
     *
     * @author fan_jane
     */
    @Override
    public PageResult<AmendingTaskDTO> getAmendingTaskList(Integer current, Integer size, TaskQueryVO taskQueryVO) {
        IPage<AmendingTaskDTO> page= new Page<>(current, size);
        PageResult<AmendingTaskDTO> pageResult = new PageResult();
        pageResult.setPageNo(current);
        pageResult.setPageSize(size);

        if(!StringUtils.isBlank(taskQueryVO.getTaskType())&&!StringUtils.isBlank(taskQueryVO.getTaskStatus())){
            long totalCount = baseMapper.getAmendingTaskListQueryCount(taskQueryVO);
            pageResult.setTotalCount(totalCount);
            pageResult.setPageCount(totalCount % size == 0 ? totalCount / size : totalCount / size + 1);
            pageResult.setResults(baseMapper.getAmendingTaskListByePageQuery(page, taskQueryVO));
            return  pageResult;
        }
        if(!StringUtils.isBlank(taskQueryVO.getTaskType())){
            long totalCount = baseMapper.getAmendingTaskListTypeCount(taskQueryVO.getTaskType());
            pageResult.setTotalCount(totalCount);
            pageResult.setPageCount(totalCount % size == 0 ? totalCount / size : totalCount / size + 1);
            pageResult.setResults(baseMapper.getAmendingTaskListByPageType(page,taskQueryVO.getTaskType()));
            return pageResult ;
        }
        if (!StringUtils.isBlank(taskQueryVO.getTaskStatus())) {
            long totalCount = baseMapper.getAmendingTaskListStatusCount(taskQueryVO.getTaskStatus());
            pageResult.setTotalCount(totalCount);
            pageResult.setPageCount(totalCount % size == 0 ? totalCount / size : totalCount / size + 1);
            pageResult.setResults(baseMapper.getAmendingTaskListByPageStatus(page,taskQueryVO.getTaskStatus()));
            return pageResult;
        }


        long totalCount = baseMapper.getAmendingTaskListCount();
        pageResult.setTotalCount(totalCount);
        pageResult.setPageCount(totalCount % size == 0 ? totalCount / size : totalCount / size + 1);
        pageResult.setResults(baseMapper.getAmendingTaskListByPage(page));

        return pageResult;




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
        NumberFormat nf  =  NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits( 1 );
        taskStatisticAppDTO.setFinishPercentage(nf.format(p3));

        return taskStatisticAppDTO;
    }

    /**
     *
     *
     */
    @Override
    public List<InspectorDTO> getInspectorList() {
        List<InspectorDTO> inspectorDTOList=baseMapper.selectInspectorList();
        for (InspectorDTO inspectorDTO :
                inspectorDTOList) {
            inspectorDTO.setChildren(baseMapper.selectTaskByInspector(inspectorDTO.getId()));
        }
        return inspectorDTOList;
    }

    //App待确认页面，每日一次
    public List<TaskAppListDTO> getTaskAppList(Integer taskStatus,Integer inspectionFrequency) {
        return baseMapper.selectTaskAppList(taskStatus,inspectionFrequency);
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
     *
     */
    @Override
    public void saveTask(TaskVO taskVO) {
        String taskId = businessCodeService.generateBusinessCode("t_task");
        baseMapper.addTask(taskId,taskVO);
        baseMapper.addTaskComponent(taskId,taskVO.getComponentNumberDTOS());
    }
    /**
     * TODO
     * 巡检内容
     * 添加任务中的巡检人员
     * 并设置状态为待领取
     *
     */
    @Override
    public void distributeTask(String taskId, String userId) {
        baseMapper.addInspectorToTask(taskId,userId);
    }
    /**
     *
     *
     */
    @Override
    public TaskContentDTO getTaskContent(String taskId) {
        TaskContentDTO taskContentDTO = new TaskContentDTO();
        taskContentDTO.setInspectionPosition(baseMapper.getInspectionPosition(taskId));
        taskContentDTO.setChildren(baseMapper.getComponentNumberRange(baseMapper.getComponentList(taskId), taskId));
        return taskContentDTO;
    }

}
