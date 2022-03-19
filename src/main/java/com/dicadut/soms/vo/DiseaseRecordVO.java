package com.dicadut.soms.vo;

import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-19 23:38
 */
@Data
public class DiseaseRecordVO {

    //component
    private String componentNumber;
    private String bridgePosition;
    //disease
    private String name;

    //bridge
    private String location;
    //diseaseRecord
    private String recordId;
    private String attribute;

}
