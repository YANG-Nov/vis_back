package com.dicadut.soms.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author fan_jennifer
 * @create 2021-11-06 19:20
 */
@Data
public class TaskDisplayDTO {
    private String id;
    private Date createTime;
    private String creatorId;
    private Date beginTime;
    private Date endTime;
    private String componentId;
    private String userId;
    private Integer taskStatus;
}
