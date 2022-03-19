package com.dicadut.soms.service;

import com.dicadut.soms.domain.TaskBridgeComponent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.BridgeComponentTest;

import java.util.List;

/**
 * <p>
 * 任务桥构件表 服务类
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-27
 */
public interface TaskBridgeComponentService extends IService<TaskBridgeComponent> {
   //改bridgeComponent表
   List<BridgeComponentTest> getName();
   //改bridgeComponent表
   List<BridgeComponentTest> setBridgePosition();
}
