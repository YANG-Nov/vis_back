package com.dicadut.soms.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Dictionary;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.domain.User;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.enumeration.SomsConstant;
import com.dicadut.soms.enumeration.TaskStatusEnum;
import com.dicadut.soms.enumeration.TypeNameEnum;
import com.dicadut.soms.mapper.BridgeComponentMapper;
import com.dicadut.soms.mapper.TaskBridgeComponentMapper;
import com.dicadut.soms.mapper.TaskMapper;
import com.dicadut.soms.service.BusinessCodeService;
import com.dicadut.soms.service.DictionaryService;
import com.dicadut.soms.service.TaskService;
import com.dicadut.soms.service.UserService;
import com.dicadut.soms.util.TaskUtil;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fan_jennifer
 * @date 2021-10-2021/10/22 19:38
 */
@Slf4j
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Resource
    private TaskBridgeComponentMapper taskBridgeComponentMapper;

    @Resource
    private BusinessCodeService businessCodeService;

    @Resource
    private DictionaryService dictionaryService;

    @Resource
    private BridgeComponentMapper bridgeComponentMapper;

    @Resource
    private UserService userService;


    @Override
    public List<TaskDTO> getTaskStatusLatestList() {
        return baseMapper.selectTaskStatusLatestList();
    }

    /**
     * 根据taskStatus获取任务列表， 如taskStatus为null或空串，则获取所有任务列表
     *
     * @param taskStatus 参考 TaskStatusEnum 的定义
     * @return 任务列表
     */
    @Deprecated
    private List<TaskDisplayDTO> getTaskDisplayList(String taskStatus) {
        QueryWrapper<Task> wrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(taskStatus)) {
            wrapper.eq("task_status", taskStatus);
        }

        List<Task> tasks = baseMapper.selectList(wrapper);
        List<TaskDisplayDTO> taskDisplayDTOS = new ArrayList<>();

        for (Task task : tasks) {
            TaskDisplayDTO taskDisplayDTO = new TaskDisplayDTO();
            BeanUtils.copyProperties(task, taskDisplayDTO);//需要类型也一致吗
            taskDisplayDTOS.add(taskDisplayDTO);


        }
        return taskDisplayDTOS;
    }


    @Override
    @Deprecated
    public List<TaskDisplayDTO> getUnclaimedTaskList() {
        return getTaskDisplayList(TaskStatusEnum.WAIT_RECEIVE.getValue());
    }

    @Override
    @Deprecated
    public List<TaskDisplayDTO> getAreInspectionTaskList() {
        return getTaskDisplayList(TaskStatusEnum.INSPECTING.getValue());
    }

    @Override
    @Deprecated
    public List<TaskDisplayDTO> getCompletedTaskList() {
        return getTaskDisplayList(TaskStatusEnum.WAIT_REVIEW.getValue());
    }

    /**
     * 法一：
     * 该方法首先将所有本年度的任务都从数据库中读取到内存，然后再在内存中统计各类状态的任务数，对于小数据场景可行，但大数据场景会
     * 导致性能很低下，甚至不可用，后续我再提供一个新的方法做参考
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 年度列表
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
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 年度列表
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
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 年度列表
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
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(1);
        taskStatisticAppDTO.setFinishPercentage(nf.format(p3));

        return taskStatisticAppDTO;
    }

    /**
     * 一次查库得人员表任务表桥梁表的相关属性
     *
     * @return 人员相关信息列表
     * @author fan_jane
     */
    @Override
    public List<InspectorDTO> getInspectorList() {
        List<InspectorDTO> inspectorDTOList = baseMapper.selectInspectorList();
        int i = 1;
        for (InspectorDTO inspectorDTO : inspectorDTOList) {
            inspectorDTO.setKey(i++);
        }

        return inspectorDTOList;
    }

    /**
     * App任务列表
     *
     * @param taskStatus 任务状态
     * @return
     */
    public List<TaskAppListDTO> getTaskAppList(Integer taskStatus) {
        // 理论上这三个list的长度要一样，即任务数，否则可能有bug
        List<TaskEndTimeAppListDTO> taskEndTimeAppList = baseMapper.selectTaskEndTimeAppList(taskStatus);
        List<TaskInspectionAppListDTO> taskInspectionAppList = baseMapper.selectTaskInspectionAppList(taskStatus);
        List<TaskDetailsAppListDTO> taskDetailsAppList = baseMapper.selectTaskDetailsAppList(taskStatus);

        List<TaskAppListDTO> taskAppListDTOList = new ArrayList();  // 存放结果列表

        // 理论上这三个map的长度要一样，即任务数，否则可能有bug
        Map<String, TaskEndTimeAppListDTO> taskEndTimeMap = taskEndTimeAppList.stream().collect(Collectors.toMap(TaskEndTimeAppListDTO::getId, e -> e, (e1, e2) -> e1)); // 将obj1List转成 map
        Map<String, TaskInspectionAppListDTO> taskInspectionMap = taskInspectionAppList.stream().collect(Collectors.toMap(TaskInspectionAppListDTO::getId, e -> e, (e1, e2) -> e1));  // 将obj2List转成 map
        Map<String, TaskDetailsAppListDTO> taskDetailsMap = taskDetailsAppList.stream().collect(Collectors.toMap(TaskDetailsAppListDTO::getId, e -> e, (e1, e2) -> e1)); // 将obj3List转成 map

        // 任意遍历一个map的key，比如obj1Map
        taskEndTimeMap.keySet().forEach(key -> {
            TaskAppListDTO of = new TaskAppListDTO();
            BeanUtil.copyProperties(taskEndTimeMap.get(key), of); // 将 obj1 的属性 copy 到 of  对象
            BeanUtil.copyProperties(taskInspectionMap.get(key), of); // 将 obj2 的属性 copy 到 of  对象
            BeanUtil.copyProperties(taskDetailsMap.get(key), of); // 将 obj3 的属性 copy 到 of  对象
            taskAppListDTOList.add(of);
        });
        return taskAppListDTOList;
    }


    /**
     * 添加任务的方法
     * 把taskVo添加到task
     * 并设置状态为待分配
     *
     * @param taskVO 添加的任务信息
     *               暂时没有 Jane_TODO 2022/2/24 需要优化
     * @author FanJane
     */
    @Override
    public void saveTask(TaskVO taskVO) {

        //自动生成任务id
        String taskId = businessCodeService.generateBusinessCode(SomsConstant.TASK);

        //复制task信息
        Task task = new Task();
        BeanUtils.copyProperties(taskVO, task);

        //设置任务id和任务状态变为待分配
        task.setId(taskId);
        task.setTaskStatus(TaskStatusEnum.WAIT_DISTRIBUTE.getValue());

        //获得巡检部位
        List<String> inspectionPositions = new ArrayList<>();

        //获得打卡位置拼成字符串加入构件DTO
        List<SubTaskVO> subTaskVOS = taskVO.getSubTasks();
        for (SubTaskVO subTaskVO : subTaskVOS) {
            //获得起始终止桩号
            String inspectionEnd = subTaskVO.getInspectionEnd();
            String inspectionStart = subTaskVO.getInspectionStart();
            String selectedComponents = StringUtils.join(subTaskVO.getSelectedComponents(), ",");
            List<SelectedComponentsDTO> selectedComponentsDTOS = baseMapper.selectComponents(inspectionStart, inspectionEnd, selectedComponents);
            //获得打卡位置
            String[] scanPositions = subTaskVO.getScanPositions();
            //1.根据code查数据库返回codename
            QueryWrapper<Dictionary> scanWrapper = new QueryWrapper<>();
            scanWrapper.in("code", scanPositions);
            List<Dictionary> dictionaries = dictionaryService.list(scanWrapper);
            List<String> collect = dictionaries.stream().map(Dictionary::getCodeName).collect(Collectors.toList());
            String scanPosition = StringUtils.join(collect, ",");
            subTaskVO.setScanPosition(scanPosition);
            //子任务获得巡检位置
            String location = selectedComponentsDTOS.get(0).getLocation();
            List<String> positions = selectedComponentsDTOS.stream().map(SelectedComponentsDTO::getName).distinct().collect(Collectors.toList());
            String locationPositions = location + String.join("、", positions);
            inspectionPositions.add(locationPositions);

            //获得桥构件id
            List<String> bridgeComponentId = selectedComponentsDTOS.stream().map(SelectedComponentsDTO::getId).distinct().collect(Collectors.toList());
            //插入任务构件表
            taskBridgeComponentMapper.addTaskComponent(taskId, subTaskVO, bridgeComponentId);
        }
        //获得任务的所有巡检位置
        String inspectionPosition = String.join(";" + inspectionPositions);
        task.setInspectionPosition(inspectionPosition);
        //插入任务表
        baseMapper.insert(task);


    }

    /**
     * 巡检内容
     * 添加任务中的巡检人员
     * 并设置状态为待领取
     *
     * @param taskId 任务id
     * @param userId 巡检人员id
     * @author fan_jane
     */
    @Override
    public void distributeTask(String taskId, String userId) {
        baseMapper.addInspectorToTask(taskId, userId);
    }

    /**
     * 在添加完任务之后跳转的到任务列表例，点击查看按钮，查看该行任务详情
     * 前端传过来当前行的任务id，
     *
     * @param taskId 当前任务id
     * @return 返回二级任务列表，一级为巡检位置，二级为构件
     * @author FanJane
     */
    @Override
    @Deprecated
    public TaskContentDTO<SubTaskShowV0> getTaskContent(String taskId) {

        //获得巡检部位 主引桥+匝道+桥面系/上下部结构
        //TaskContentDTO taskContentDTO = new TaskContentDTO();
        //taskContentDTO.setInspectionPosition(baseMapper.getInspectionPosition(taskId));

        //获取该任务包含的构件id集合
        //List<String> componentList = baseMapper.getComponentList(taskId);

        //查询当前id的构件范围
        //taskContentDTO.setChildren(baseMapper.getComponentNumberRange(componentList, taskId));
        return null;
    }

    @Override
    public List<TaskScanPositionAppListDTO> getTaskScanPositionAppList(String taskId) {
        return baseMapper.selectTaskScanPositionAppList(taskId);
    }

    /**
     * // Jane_TODO add description
     *
     * @param taskId 任务id
     * @return com.dicadut.soms.dto.TaskContentDTO
     * @author FanJane
     */
    @Override
    public TaskContentDTO<SubTaskShowV0> showTaskContent(String taskId) {
        // Wei_TODO 2022/2/24 底层实现得改//FIX
        TaskContentDTO<SubTaskShowV0> taskContentDTO = new TaskContentDTO();
        List<TaskBridgeComponentDTO> taskBridgeComponentList = baseMapper.getTaskBridgeComponentList(taskId);

        //获得任务信息
        TaskBridgeComponentDTO taskBridgeComponentDTO = taskBridgeComponentList.get(0);
        BeanUtils.copyProperties(taskBridgeComponentDTO, taskContentDTO);

        //获得打卡点位置
        List<TaskBridgeComponentDTO> collect = taskBridgeComponentList.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(TaskBridgeComponentDTO::getScanPosition))), ArrayList::new));
        Set<String> scanPositionSet = TaskUtil.ArrayToSet(collect.stream().map(TaskBridgeComponentDTO::getScanPosition).collect(Collectors.toList()));
        taskContentDTO.setScanPositions(scanPositionSet);

        //获得子任务
        List<SubTaskShowV0> SubTaskShowV0s = new ArrayList<>();
        Map<String, List<TaskBridgeComponentDTO>> map = taskBridgeComponentList.stream().collect(Collectors.groupingBy(TaskBridgeComponentDTO::getLocation));

        for (Map.Entry<String, List<TaskBridgeComponentDTO>> entry : map.entrySet()) {
            SubTaskShowV0 SubTaskShowV0 = new SubTaskShowV0();
            List<TaskBridgeComponentDTO> taskBridgeComponentDTOS = entry.getValue();
            //获得巡检部位
            HashSet<String> compositionList = new HashSet<>();
            for (TaskBridgeComponentDTO t : taskBridgeComponentDTOS) {
                String[] xName = t.getXname().split("/");
                compositionList.add(xName[2]);
            }
            String location = entry.getKey();
            String composition = StringUtils.join(compositionList.toArray(), "、");
            SubTaskShowV0.setInspectionPosition(location + composition);

            //获得巡检路线
            String inspectionRoute = taskBridgeComponentDTOS.get(0).getInspectionRoute();
            SubTaskShowV0.setInspectionRoute(inspectionRoute);

            //获得巡检构件
            List<String> inspectionComponentNumber = TaskUtil.getInspectionComponentNumbers(taskBridgeComponentDTOS);

            SubTaskShowV0.setSelectedComponents(inspectionComponentNumber.toArray(new String[inspectionComponentNumber.size()]));
            SubTaskShowV0s.add(SubTaskShowV0);
        }
        taskContentDTO.setSubTasks(SubTaskShowV0s);


        return taskContentDTO;


    }

    /**
     * 选择巡检范围后弹出所有打卡位置，并默认勾选构件包含的打卡位置
     *
     * @param inspectionScopeVO 巡检范围起始桩号
     * @return CheckBox <ScanPositionDTO> 显示打卡位置
     * @author FanJane
     */
    @Override
    public CheckBox<ScanPositionDTO> getTaskScanPosition(InspectionScopeVO inspectionScopeVO) {
        CheckBox<ScanPositionDTO> scanPositionDTOCheckBox = new CheckBox<>();
        //获得所有打卡位置
        List<TypeNameDTO> typeNameDTOS = dictionaryService.getTypeNames(TypeNameEnum.SCAN_POSITION.getValue());
        List<ScanPositionDTO> option = new ArrayList<>(typeNameDTOS);

        scanPositionDTOCheckBox.setOption(option);
        //获得该桩号范围内的打卡位置
        List<ScanPositionDTO> selected = baseMapper.getScanPositionList(inspectionScopeVO.getStart(), inspectionScopeVO.getEnd());
        List<String> codes = selected.stream().map(ScanPositionDTO::getCode).collect(Collectors.toList());
        scanPositionDTOCheckBox.setSelected(codes);
        return scanPositionDTOCheckBox;
    }

    /**
     * // Jane_TODO add description
     *
     * @param taskId 任务id
     * @author FanJane
     */
    @Override
    public void removeTask(String taskId) {
        //删除任务表
        baseMapper.deleteById(taskId);
        //删除bridge_component表
        HashMap<String, Object> removeByTaskId = new HashMap<>();
        removeByTaskId.put("task_id", taskId);
        taskBridgeComponentMapper.deleteByMap(removeByTaskId);
    }

    @Override
    public void updateTaskStatus(String taskId, String taskStatusIdGo) {
        baseMapper.updateTaskStatus(taskId, taskStatusIdGo);
    }

    @Override
    public void updateReceiveTime(String taskId, String taskReceiveTime) {
        baseMapper.updateTaskReceiveTime(taskId, taskReceiveTime);
    }

    @Override
    public void updateFinishTime(String taskId, String taskFinishTime) {
        baseMapper.updateTaskFinishTime(taskId, taskFinishTime);
    }

    @Override
    public TaskContentDTO<SubTaskShowV0> getTaskPreview(TaskVO taskVO) {
        //获取表单需要的数据
        TaskContentDTO<SubTaskShowV0> taskContentDTO = new TaskContentDTO();
        List<SubTaskShowV0> subTaskShowV0List = new ArrayList<>();

        //1.获得任务时间
        BeanUtils.copyProperties(taskVO, taskContentDTO);
        //2.获得任务类型
        QueryWrapper<Dictionary> taskTypeWrapper = new QueryWrapper<>();
        Dictionary taskType = dictionaryService.getOne(taskTypeWrapper.eq("code", taskVO.getTaskType()));
        taskContentDTO.setTaskType(taskType.getCodeName());
        //3.获得任务制定人

        User createBy = userService.getById(taskVO.getCreateBy());
        taskContentDTO.setCreateBy(createBy.getRealName());
        //4.获得巡检频率
        QueryWrapper<Dictionary> frequencyWrapper = new QueryWrapper<>();
        Dictionary frequency = dictionaryService.getOne(frequencyWrapper.eq("code", taskVO.getInspectionFrequency()));
        taskContentDTO.setInspectionFrequency(frequency.getCodeName());
        //5.设定任务状态
        taskContentDTO.setTaskStatus(TaskStatusEnum.WAIT_RECEIVE.getLabel());
        //将数据库封装调用写好的方法


        //获得打卡点位置
        List<SubTaskVO> subTasks = taskVO.getSubTasks();
        Set<String> scanPositionSet = new HashSet<>();
        for (SubTaskVO subTaskVO : subTasks) {
            SubTaskShowV0 subTaskShowV0 = new SubTaskShowV0();
            //获得打卡点位置
            scanPositionSet.addAll(Arrays.asList(subTaskVO.getScanPositions()));
            //获得巡检部位
            HashSet<String> compositionList = new HashSet<>();
            String selectedComponents = StringUtils.join(subTaskVO.getSelectedComponents(), ",");
            List<TaskBridgeComponentDTO> taskBridgeComponentDTOS = baseMapper.getPosition(subTaskVO.getInspectionStart()
                    , subTaskVO.getInspectionEnd(), selectedComponents);
            for (TaskBridgeComponentDTO t : taskBridgeComponentDTOS) {
                String[] xName = t.getXname().split("/");
                compositionList.add(xName[2]);
            }
            String location = taskBridgeComponentDTOS.get(0).getLocation();
            String composition = StringUtils.join(compositionList.toArray(), "、");
            subTaskShowV0.setInspectionPosition(location + composition);
            //获得巡检路线
            subTaskShowV0.setInspectionRoute(subTaskVO.getInspectionRoute());
            //获得巡检构件
            List<String> inspectionComponentNumbers = TaskUtil.getInspectionComponentNumbers(taskBridgeComponentDTOS);
            subTaskShowV0.setSelectedComponents(inspectionComponentNumbers.toArray(new String[inspectionComponentNumbers.size()]));
            subTaskShowV0List.add(subTaskShowV0);
        }

        QueryWrapper<Dictionary> scanWrapper = new QueryWrapper<>();
        List<Dictionary> scan = dictionaryService.list(scanWrapper.in("code", scanPositionSet));
        taskContentDTO.setScanPositions(scan.stream().map(Dictionary::getCodeName).collect(Collectors.toSet()));

        taskContentDTO.setSubTasks(subTaskShowV0List);


        return taskContentDTO;
    }

    @Override
    public TaskContentDTO<SubTaskUpdateV0> getUpdateTask(String taskId) {
        TaskContentDTO<SubTaskUpdateV0> taskContentDTO = new TaskContentDTO();
        List<TaskBridgeComponentDTO> taskBridgeComponentList = baseMapper.getUpdateTaskList(taskId);

        //获得任务信息
        TaskBridgeComponentDTO taskBridgeComponentDTO = taskBridgeComponentList.get(0);
        BeanUtils.copyProperties(taskBridgeComponentDTO, taskContentDTO);

        //获得打卡点位置
        List<TaskBridgeComponentDTO> collect = taskBridgeComponentList.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(TaskBridgeComponentDTO::getScanPosition))), ArrayList::new));

        Set<String> scanPositionSet = collect.stream().map(TaskBridgeComponentDTO::getScanPosition).collect(Collectors.toSet());
        Set<String> strings = new HashSet<>();
        for (String s : scanPositionSet) {
            String[] split = s.split(",");
            List<String> strings1 = Arrays.asList(split);
            strings.addAll(strings1);
        }
        QueryWrapper<Dictionary> queryWrapper = new QueryWrapper<>();
        List<Dictionary> codeName = dictionaryService.list(queryWrapper.in("code_name", strings));
        Set<String> collect1 = codeName.stream().map(Dictionary::getCode).collect(Collectors.toSet());
        taskContentDTO.setScanPositions(collect1);

        //获得子任务
        List<SubTaskUpdateV0> subTaskUpdateV0s = new ArrayList<>();
        Map<String, List<TaskBridgeComponentDTO>> map = taskBridgeComponentList.stream().collect(Collectors.groupingBy(TaskBridgeComponentDTO::getLocation));

        for (Map.Entry<String, List<TaskBridgeComponentDTO>> entry : map.entrySet()) {
            SubTaskUpdateV0 subTaskUpdateV0 = new SubTaskUpdateV0();
            List<TaskBridgeComponentDTO> taskBridgeComponentDTOS = entry.getValue();
            //获得巡检起始桩号
            String[] inspectionStart;
            inspectionStart = new String[2];
            inspectionStart[0] = taskBridgeComponentDTOS.get(0).getLocation();
            inspectionStart[1] = taskBridgeComponentDTOS.get(0).getInspectionStart();
            subTaskUpdateV0.setInspectionStart(inspectionStart);
            String[] inspectionEnd;
            inspectionEnd = new String[2];
            inspectionEnd[0] = taskBridgeComponentDTOS.get(0).getLocation();
            inspectionEnd[1] = taskBridgeComponentDTOS.get(0).getInspectionEnd();
            subTaskUpdateV0.setInspectionEnd(inspectionEnd);
            //获得巡检构件
            subTaskUpdateV0.setSelectedComponents(taskBridgeComponentDTOS.stream().map(TaskBridgeComponentDTO::getComponentId).distinct().toArray(String[]::new));
            subTaskUpdateV0s.add(subTaskUpdateV0);
        }
        taskContentDTO.setSubTasks(subTaskUpdateV0s);


        return taskContentDTO;


    }

    /**
     * // Jane_TODO add description
     *
     * @param currentPage 当前页
     * @param pageSize    每页显示数量
     * @param taskQueryVO 查询条件
     * @return 带分页的任务列表
     * @author FanJane
     */
    @Override
    public PageResult<TaskSetDTO> getTaskList(Integer currentPage, Integer pageSize, TaskQueryVO taskQueryVO) {
        IPage<TaskSetDTO> page = new Page<>(currentPage, pageSize);
        if (TaskStatusEnum.RETRANSMIT.getValue().equals(taskQueryVO.getTaskStatus())) {
            taskQueryVO.setTaskStatus(TaskStatusEnum.WAIT_REVIEW_AGAIN.getValue() + "," +
                    TaskStatusEnum.WAIT_RETRANSMIT.getValue() + "," + TaskStatusEnum.WAIT_REVIEW.getValue());
        }
        if (TaskStatusEnum.INSPECTING.getValue().equals(taskQueryVO.getTaskStatus())) {
            taskQueryVO.setTaskStatus(TaskStatusEnum.INSPECTING.getValue() + "," + TaskStatusEnum.WAIT_INSPECTION.getValue());
        }
        if (TaskStatusEnum.MANAGING_TASK.getValue().equals(taskQueryVO.getTaskStatus())) {
            taskQueryVO.setTaskStatus(TaskStatusEnum.MANAGING_TASK.getLabel());
        }
        baseMapper.getTaskList(page, taskQueryVO);
        return PageResult.buildPage(page);
    }


}
