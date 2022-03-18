package com.dicadut.soms.service;


import com.dicadut.soms.vo.TaskQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-12-31 16:50:18
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceTest {

    @Resource
    private TaskService taskService;

    @Test
    public void getTaskRecord() {
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("{}", taskService.getTaskRecord("20220119000001"));
        log.info("#### 结束单元测试 getThisYearTaskList");
    }

    @Test
    public void getThisYearTaskList() {
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("{}", taskService.getThisYearTaskList("2021-01-01 00:00:00", "2021-12-31 23:59:59"));
        log.info("#### 结束单元测试 getThisYearTaskList");
    }

    @Test
    public void getThisYearTaskListByMultiSql() {
        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        log.info("{}", taskService.getThisYearTaskListByMultiSql("2021-01-01 00:00:00", "2021-12-31 23:59:59"));
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }

    @Test
    public void selectTaskStatisticByTaskStatus() {
        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        log.info("{}", taskService.getThisYearTaskListBySingleSql("2021-01-01 00:00:00", "2021-12-31 23:59:59"));
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }


    @Test
    public void distributeTask() {
        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        taskService.distributeTask("20220118000002", "1448232280441845762");
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }

    @Test
    public void getAmendingTaskList() {
        TaskQueryVO taskQueryVO = new TaskQueryVO();
//        taskQueryVO.setTaskType("1001000001");
//        taskQueryVO.setTaskStatus("1002000004");
        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        log.info("{}", taskService.getTaskList(1, 2,taskQueryVO));
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }
    @Test
    public void getInspectorList() {
        TaskQueryVO taskQueryVO = new TaskQueryVO();
        taskQueryVO.setTaskType("1001000005");
        taskQueryVO.setTaskStatus("1002000004");
        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        log.info("{}", taskService.getInspectorList());
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }

    @Test
    public void showTaskContent() {
        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        log.info("{}", taskService.showTaskContent("2"));
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }

    @Test public  void  getUpdateTask(){
        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        log.info("{}", taskService.getUpdateTask("20220119000001"));
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }


}
