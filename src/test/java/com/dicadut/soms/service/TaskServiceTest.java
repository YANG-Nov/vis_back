package com.dicadut.soms.service;


import com.dicadut.soms.dto.ComponentNumberDTO;
import com.dicadut.soms.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void saveTask() {
        TaskVO taskVO = new TaskVO();
        List<ComponentNumberDTO> objects = new ArrayList<>();
        ComponentNumberDTO componentNumberDTO = new ComponentNumberDTO();
        componentNumberDTO.setNumber("32432");
        componentNumberDTO.setId("2");
        objects.add(componentNumberDTO);
        taskVO.setStartTime(LocalDateTime.now());
        taskVO.setTaskType("1001000001");
        taskVO.setEndTime(LocalDateTime.now());
        taskVO.setRecallTime(LocalDateTime.now());
        taskVO.setReceiveTime(LocalDateTime.now());
        taskVO.setCreateBy("1448237380441845762");
        taskVO.setComponentNumberDTOS(objects);

        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        taskService.saveTask(taskVO);
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }
    @Test
    public void distributeTask() {
        log.info("#### 启动单元测试 getThisYearTaskListByMultiSql");
        taskService.distributeTask("20220118000002", "1448232280441845762");
        log.info("#### 结束单元测试 getThisYearTaskListByMultiSql");
    }

}
