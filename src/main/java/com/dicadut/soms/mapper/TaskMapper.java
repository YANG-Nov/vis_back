package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dicadut.soms.domain.Task;
import com.dicadut.soms.dto.*;
import com.dicadut.soms.vo.TaskQueryVO;
import com.dicadut.soms.vo.TaskVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-10-2021/10/22 19:41
 */
@Mapper
public interface TaskMapper extends BaseMapper<Task> {

    Integer selectCountByTaskStatus(@Param("startTime") String startTime,
                                    @Param("endTime") String endTime,
                                    @Param("taskStatus") String taskStatus);

    TaskStatisticDTO selectTaskStatisticByTaskStatus(@Param("startTime") String startTime,
                                                     @Param("endTime") String endTime);

    TaskStatisticAppDTO selectTaskStatisticAppByTaskStatus(@Param("startTime") String startTime,
                                                           @Param("endTime") String endTime);

    // Wei_TODO 2022/2/24 1状态提到Java层做 2查询层级改成韦雷哥代码
    List<InspectorDTO> selectInspectorList();

    List<TaskEndTimeAppListDTO> selectTaskEndTimeAppList(@Param("taskStatus") Integer taskStatus);

    List<TaskInspectionAppListDTO> selectTaskInspectionAppList(@Param("taskStatus") Integer taskStatus);

    List<TaskDetailsAppListDTO> selectTaskDetailsAppList(@Param("taskStatus") Integer taskStatus);

    List<TaskDTO> selectTaskStatusLatestList();

    /**
     * 添加任务信息，并把任务状态设置为 1002000004 待分配
     *
     * @param taskId 自动生成的任务id
     * @param taskVO 前端传过来的任务信息
     * @author FanJane
     */
    @Deprecated
    void addTask(@Param("taskId") String taskId,
                 @Param("taskVO") TaskVO taskVO);


    void addInspectorToTask(@Param("taskId") String taskId,
                            @Param("userId") String userId);

    IPage<AmendingTaskDTO> getAmendingTaskListByePageQuery(IPage<AmendingTaskDTO> page, @Param("taskQueryVO") TaskQueryVO taskQueryVO);

    /**
     * 根据当前任务id查询任务构件编号表，桥梁构件关联表，，构件表，桥梁表
     *
     * @param taskId 当前任务id
     * @return 主引桥+匝道+桥面系/上下部结构
     * @author FanJane
     */
    @Deprecated
    String getInspectionPosition(@Param("taskId") String taskId);

    /**
     * 使用foreache循环遍历构件id集合，查询每类构件id构件编号的范围
     *
     * @param list   构件id集合
     * @param taskId 任务id
     * @return 构件编号集合，连续的用破折号，不连续的用顿号
     * @author FanJane
     */
    @Deprecated
    List<ComponentNumberTotalDTO> getComponentNumberRange(@Param("list") List<String> list,
                                                          @Param("taskId") String taskId);

    /**
     * 根据任务id，查询桥梁构件编号表和桥梁构件表，获取的构件表的id
     *
     * @param taskId 当前行的任务id
     * @return 构件列表页的构件id集合
     * @author FanJane
     */
    @Deprecated
    List<String> getComponentList(@Param("taskId") String taskId);

    List<TaskScanPositionAppListDTO> selectTaskScanPositionAppList(String taskId);

    /**
     * // Jane_TODO add description
     *
     * @param
     * @return void
     * @author FanJane
     */
    List<TaskBridgeComponentDTO> getTaskBridgeComponentList(String taskId);

    /**
     * 获得桩号范围内构件的打卡位置，查询bridge和bridge_component和dictionary表，并返回dictionary表中的code 和codeName集合
     *
     * @param start 开始桩号 bridge表中的id
     * @param end 结束桩号  bridge表中的id
     * @return List<ScanPositionDTO> dictionary表中的code 和codeName集合
     * @author FanJane
     */
    List<ScanPositionDTO> getScanPositionList(@Param("start") String start, @Param("end") String end);

    void updateTaskStatus(@Param("taskId") String taskId, @Param("taskStatusIdGo") String taskStatusIdGo);
}
