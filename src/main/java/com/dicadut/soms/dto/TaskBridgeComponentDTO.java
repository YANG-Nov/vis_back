package com.dicadut.soms.dto;

import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-02-28 15:55
 */
@Data
public class TaskBridgeComponentDTO {
    private String taskId;
    private String taskType;
    private String taskStatus;
    private String inspectionFrequency;
    private String creatBy;
    private String inspector;
    private String startTime;
    private String endTime;
    private String receiveTime;
    private String recallTime;
    private String location;
    private String xname;
    private String xpath;
    private String scanPosition;
    private String componentName;
    private String componentNumber;
    private String inspectionRoute;

}
