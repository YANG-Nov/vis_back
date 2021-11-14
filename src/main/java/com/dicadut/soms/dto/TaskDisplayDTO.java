package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/6 19:20
 */
@Data
public class TaskDisplayDTO {
    private String id;
    private String createTime;
    private String creatorId;
    private String beginTime;
    private String endTime;
    private String componentId;
    private String userId;
    private String taskStatus;



}
