package com.dicadut.soms.dto;

import lombok.Data;


/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:09 下午 2022/3/2
 * @ Description：病害记录表
 * @Version: 1.0.0$
 */
@Data
public class DiseaseRecordTableListDTO {
    private String taskId;
    private String location;
    private String parentComponent;
    private String parentComponentId;
    private String componentId;
    private String component;
    private String positionId;
    private String position;
    private String diseaseId;
    private String disease;
}
