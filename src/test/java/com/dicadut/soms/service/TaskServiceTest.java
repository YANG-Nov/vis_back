package com.dicadut.soms.service;


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
}