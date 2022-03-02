package com.dicadut.soms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-19 19:48
 */
@Data
public class TaskContentDTO {
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
    private Set<String> scanPosition;
    private List<SubTaskShowV0> subTask = new ArrayList<>();
}
