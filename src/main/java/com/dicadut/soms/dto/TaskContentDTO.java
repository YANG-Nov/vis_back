package com.dicadut.soms.dto;


import com.dicadut.soms.Annotation.EnumMapper;
import com.dicadut.soms.enumeration.AllEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @EnumMapper(AllEnum.class)
    @JsonProperty("jobType")
    private String taskType;

    @JsonProperty("jobStatus")
    @EnumMapper(AllEnum.class)
    private String taskStatus;

    @JsonProperty("jobFreq")
    @EnumMapper(AllEnum.class)
    private String inspectionFrequency;

    @EnumMapper(AllEnum.class)
    private String createBy;

    @EnumMapper(AllEnum.class)
    private String inspector;

    private LocalDate startTime;
    private LocalDate endTime;
    private LocalDate remindTime;
    private LocalDateTime receiveTime;
    private LocalDateTime finishTime;

    private LocalDate recallTime;
    private Set<String> scanPositions;
    private List<E> subTasks = new ArrayList<>();
}
