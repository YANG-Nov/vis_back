package com.dicadut.soms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-19 19:48
 */
@Data
public class TaskContentDTO<E> {
    private String taskId;
    @JsonProperty("jobType")
    private String taskType;
    @JsonProperty("jobStatus")
    private String taskStatus;
    @JsonProperty("jobFreq")
    private String inspectionFrequency;
    private String creatBy;
    private String inspector;
    private LocalDate startTime;
    private LocalDate endTime;

    @JsonProperty("remindTime")
    private LocalDate receiveTime;

    private LocalDate recallTime;
    private Set<String> scanPositions;
    private List<E> subTasks = new ArrayList<>();
}
