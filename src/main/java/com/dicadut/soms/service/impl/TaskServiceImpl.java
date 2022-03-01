package com.dicadut.soms.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.enumeration.SomsConstant;
import com.dicadut.soms.enumeration.TaskStatusEnum;
import com.dicadut.soms.mapper.TaskBridgeComponentMapper;
import com.dicadut.soms.mapper.TaskMapper;
import com.dicadut.soms.service.BusinessCodeService;
import com.dicadut.soms.service.TaskService;
import com.dicadut.soms.util.TaskUtil;
import com.dicadut.soms.viewmodel.PageResult;
import com.dicadut.soms.vo.TaskQueryVO;
import com.dicadut.soms.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
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

    /**
     * 前端传过来查询条件对象，返回带分页的任务列表
     *
     * @param currentPage 第几页
     * @param pageSize    页大小
     * @param taskQueryVO 查询条件
     * @return 带分页插件的任务列表
     * @author fan_jane
     */
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
        // Wei_TODO 2022/2/24 一次查库得出所有数据，然后通过java构造前端要的格式， 优先级低一些ing//FIX
        List<InspectorDTO> inspectorDTOList = baseMapper.selectInspectorList();

        return inspectorDTOList;
    }

    /**
     * App任务列表
     *
     * @param taskStatus          任务状态
     * @param inspectionFrequency 巡检频率
     * @return
     */
//    public List<TaskAppListDTO> getTaskAppList(Integer taskStatus, Integer inspectionFrequency) {
////        List<TaskAppListDTO> taskEndTimeAppList = baseMapper.selectTaskEndTimeAppList(taskStatus, inspectionFrequency);
////        List<TaskAppListDTO> taskInspectionAppList = baseMapper.selectTaskInspectionAppList(taskStatus,inspectionFrequency);
////        List<TaskAppListDTO> taskDetailsAppList = baseMapper.selectTaskDetailsAppList(taskStatus,inspectionFrequency);
//        return taskEndTimeAppList;
//    }
    public List<TaskAppListDTO> getTaskAppList(Integer taskStatus, Integer inspectionFrequency) {
        // 理论上这三个list的长度要一样，即任务数，否则可能有bug
        List<TaskEndTimeAppListDTO> taskEndTimeAppList = baseMapper.selectTaskEndTimeAppList(taskStatus, inspectionFrequency);
        List<TaskInspectionAppListDTO> taskInspectionAppList = baseMapper.selectTaskInspectionAppList(taskStatus, inspectionFrequency);
        List<TaskDetailsAppListDTO> taskDetailsAppList = baseMapper.selectTaskDetailsAppList(taskStatus, inspectionFrequency);

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
     * @return 暂时没有 Jane_TODO 2022/2/24 后期需要优化
     * @author FanJane
     */
    @Override
    public void saveTask(TaskVO taskVO) {
        // Wei_TODO 方法二 //FIX

        //自动生成任务id
        String taskId = businessCodeService.generateBusinessCode(SomsConstant.TASK);

        //复制task信息
        Task task = new Task();
        BeanUtils.copyProperties(taskVO, task);

        //设置任务id和任务状态变为待分配
        task.setId(taskId);
        task.setTaskStatus(TaskStatusEnum.WAIT_DISTRIBUTE.getValue());

        //插入任务表和任务构件表
        baseMapper.insert(task);
        taskBridgeComponentMapper.addTaskComponent(taskId, taskVO.getComponentNumberDTOS());


    }

    /**
     * 巡检内容
     * 添加任务中的巡检人员
     * 并设置状态为待领取
     *
     * @param taskId
     * @param userId
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
    public TaskContentDTO getTaskContent(String taskId) {

        //获得巡检部位 主引桥+匝道+桥面系/上下部结构
        TaskContentDTO taskContentDTO = new TaskContentDTO();
        //taskContentDTO.setInspectionPosition(baseMapper.getInspectionPosition(taskId));

        //获取该任务包含的构件id集合
        List<String> componentList = baseMapper.getComponentList(taskId);

        //查询当前id的构件范围
        //taskContentDTO.setChildren(baseMapper.getComponentNumberRange(componentList, taskId));
        return taskContentDTO;
    }

    @Override
    public List<TaskScanPositionAppListDTO> getTaskScanPositionAppList(String taskId) {
        return baseMapper.selectTaskScanPositionAppList(taskId);
    }

    /**
     * // Jane_TODO add description
     *
     * @param taskId
     * @return com.dicadut.soms.dto.TaskContentDTO
     * @author FanJane
     */
    @Override
    public TaskContentDTO showTaskContent(String taskId) {
        // Wei_TODO 2022/2/24 底层实现得改//FIX
        TaskContentDTO taskContentDTO = new TaskContentDTO();
        List<TaskBridgeComponentDTO> taskBridgeComponentList = baseMapper.getTaskBridgeComponentList(taskId);

        //获得任务信息
        TaskBridgeComponentDTO taskBridgeComponentDTO = taskBridgeComponentList.get(0);
        BeanUtils.copyProperties(taskBridgeComponentDTO, taskContentDTO);

        //获得打卡点位置
        ArrayList<TaskBridgeComponentDTO> collect1 = taskBridgeComponentList.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(o -> o.getScanPosition()))), ArrayList::new));
        Set<String> scanPositionSet = TaskUtil.ArrayToSet(collect1.stream().map(TaskBridgeComponentDTO::getScanPosition).collect(Collectors.toList()));
        taskContentDTO.setScanPostion(scanPositionSet);

        //获得巡检部位
        Map<String, List<TaskBridgeComponentDTO>> map = taskBridgeComponentList.stream().collect(Collectors.groupingBy(TaskBridgeComponentDTO::getLocation));
        List<List<Tree<Integer>>> inspectPosition = new ArrayList<>();
        for (Map.Entry<String, List<TaskBridgeComponentDTO>> entry : map.entrySet()) {
            //取得key和value
            List<TreeNode<Integer>> nodeList = CollUtil.newArrayList();  // 所有树的节点列表，树枝列表
            Set<Integer> hasAddedIdSet = new HashSet<>();   // 存放已经加入到树的节点，辅助的数据结构
            List<TaskBridgeComponentDTO> taskBridgeComponentDTOS = entry.getValue();
            for (TaskBridgeComponentDTO t : taskBridgeComponentDTOS) {
                String[] xpathArray = t.getXpath().split("/");
                String[] pathArray = TaskUtil.ArraysDelete(xpathArray, 1);
                String[] xpathName = t.getXname().split("/");
                String[] nameArray = TaskUtil.ArraysDelete(xpathName, 1);
                for (int i = 0; i < pathArray.length; i++) {   // 遍历xpath中的每一级路径，构造树节点
                    //获得此节点的id和父id
                    if (i == 0) {
                        Integer id = Integer.parseInt(pathArray[i]);
                        String name = nameArray[i];
                        Integer level = i;
                        TreeNode<Integer> node = new TreeNode<>(id, 0, name, level);
                        if (!hasAddedIdSet.contains(id)) {  // 将未加入树中的节点添加到树中
                            // weight 存放level值
                            nodeList.add(node);
                            hasAddedIdSet.add(id);

                        }
                        continue;
                    }
                    Integer id = Integer.parseInt(pathArray[i]);
                    Integer parentId = Integer.parseInt(pathArray[i - 1]);
                    String name = nameArray[i];
                    Integer level = i;
                    TreeNode<Integer> node = new TreeNode<>(id, parentId, name, level); // weight 存放level值
                    if (!hasAddedIdSet.contains(id)) {  // 将未加入树中的节点添加到树中
                        nodeList.add(node);
                        hasAddedIdSet.add(id);
                    }

                }
            }
            List<Tree<Integer>> treeList = TreeUtil.build(nodeList);    // 指定根节点，创建构件树
            inspectPosition.add(treeList);
        }
        taskContentDTO.setInspectionPosition(inspectPosition);

        return taskContentDTO;


    }

}
