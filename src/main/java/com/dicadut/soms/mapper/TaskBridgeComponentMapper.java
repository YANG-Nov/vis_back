package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.domain.TaskBridgeComponent;
import com.dicadut.soms.dto.BridgeComponentTest;
import com.dicadut.soms.vo.SubTaskVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 任务桥构件表 Mapper 接口
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-27
 */
public interface TaskBridgeComponentMapper extends BaseMapper<TaskBridgeComponent> {

    /**
     * 向任务构件表里插入构件编号id和任务id
     * @author FanJane
     * @param taskId
     * @param  subTaskVO
     * @param  selectedComponents
     * @return void
     */
    int addTaskComponent(@Param("taskId") String taskId,
                          @Param("subTaskVO") SubTaskVO subTaskVO,
                          @Param("list") List<String> selectedComponents);
    //改bridgeComponent表
    List<BridgeComponentTest> getBridgeComponentList();
    //改bridgeComponent表
    void setName(@Param("bridge") String bridgeId,@Param("component") String componentId,@Param("str") String str);
    //改bridgeComponent表
    List<BridgeComponentTest> getBridgeComponentParentList();
    //改bridgeComponent表
    void setBridgePosition(@Param("bridge") String bridgeId,@Param("component") String componentId,@Param("str") String str);

}
