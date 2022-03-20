package com.dicadut.soms.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dicadut.soms.controller.DiseaseRecordController;
import com.dicadut.soms.domain.DiseaseRecord;
import com.dicadut.soms.dto.DiseaseRecordTableDTO;
import com.dicadut.soms.dto.TaskBridgeComponentDTO;
import com.dicadut.soms.enumeration.DiseaseAttributeEnum;
import com.dicadut.soms.enumeration.DiseaseUnitEnum;
import com.dicadut.soms.vo.TaskQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

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

    @Resource
    private  TaskBridgeComponentService taskBridgeComponentService;

    @Resource
    DiseaseRecordService diseaseRecordService;

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
    @Test
    public void getTaskRecord() {
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("{}", taskService.getTaskRecord("20220119000001"));
        log.info("#### 结束单元测试 getThisYearTaskList");
        log.info("#### 结束单元测试 getThisYearTaskList");
        log.info("#### 结束单元测试 getThisYearTaskList");
        log.info("#### 结束单元测试 getThisYearTaskList");
        log.info("#### 结束单元测试 getThisYearTaskList");
        log.info("#### 结束单元测试 getThisYearTaskList");
    }

    /*    //库
    @Test
    public void setName() {
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("{}", taskBridgeComponentService.getName());
        log.info("#### 结束单元测试 getThisYearTaskList");
    }*/
/*    //库
    @Test
    public void setBridgePosition() {
        log.info("#### 启动单元测试 getThisYearTaskList");
        log.info("{}", taskBridgeComponentService.setBridgePosition());
        log.info("#### 结束单元测试 getThisYearTaskList");
    }*/

/*    //库
    @Test
    public void setAttribute() {
        //得到这条任务的所有记录，分几个部位
        List<DiseaseRecordTableDTO> diseaseRecordTable = diseaseRecordService.getDiseaseRecordTable("20220306000008");
        //得到每个部位的记录
        for (DiseaseRecordTableDTO d: diseaseRecordTable) {
            //得到一个部位的所有病害记录,去重后得到唯一的record_id病害记录
            List<DiseaseRecordTableDTO.Item> disease = d.getDiseaseRecord();
            ArrayList<DiseaseRecordTableDTO.Item> diseaseRecord = disease.stream().collect(Collectors.collectingAndThen(
                    Collectors.toCollection(() -> new TreeSet<>(
                            Comparator.comparing(DiseaseRecordTableDTO.Item::getRecordId))), ArrayList::new));
            //得到库里的每一个唯一的record_id记录
            for (DiseaseRecordTableDTO.Item i: diseaseRecord  ) {
                String taskId = i.getTaskId();
                Integer recordId = i.getRecordId();
                //得到当前record_id的所有病害记录
                Set<String> strings = new HashSet<>();
                List<DiseaseRecord> diseaseRecordDeleteList = diseaseRecordService.getDiseaseRecordDeleteList(taskId, recordId);
                for (DiseaseRecord s:diseaseRecordDeleteList) {
                    if (s.getType()==1 ){
                        String diseaseAttributeId = s.getDiseaseAttributeId();
                        String content = s.getContent();
                        String st = DiseaseAttributeEnum.findByValue(diseaseAttributeId) + ":" + content + DiseaseUnitEnum.findByValue(diseaseAttributeId);
                        strings.add(st);
                    }
                    if(s.getType() == 2 || s.getType() == 3){
                        String diseaseAttributeId = s.getDiseaseAttributeId();
                        String content = s.getContent();
                        String st = DiseaseAttributeEnum.findByValue(diseaseAttributeId) + ":" + content;
                        strings.add(st);
                    }
                }
                String join = StringUtils.join(strings, ";");
                UpdateWrapper<DiseaseRecord> updateWrapper = new UpdateWrapper<>();
                updateWrapper.eq("record_id", recordId);
                updateWrapper.set("attribute", join);
                log.info("#### 启动单元测试 getThisYearTaskList");
                log.info("#### 启动单元测试 getThisYearTaskList");
                log.info("#### 启动单元测试 getThisYearTaskList");
                log.info("#### 启动单元测试 getThisYearTaskList");
                log.info("#### 启动单元测试 getThisYearTaskList");
                log.info("{}",diseaseRecordService.update(updateWrapper) );
                log.info("#### 结束单元测试 getThisYearTaskList");
                log.info("#### 结束单元测试 getThisYearTaskList");
                log.info("#### 结束单元测试 getThisYearTaskList");
                log.info("#### 结束单元测试 getThisYearTaskList");
                log.info("#### 结束单元测试 getThisYearTaskList");
                log.info("#### 结束单元测试 getThisYearTaskList");
            }
        }
    }*/
}
