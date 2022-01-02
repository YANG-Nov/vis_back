package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/6 19:20
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
