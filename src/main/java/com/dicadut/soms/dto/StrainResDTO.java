package com.dicadut.soms.dto;

import lombok.Data;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-14 16:14:55
 */
@Data
public class StrainResDTO {
    // private Integer id;
    // private String sendTime;
    private String getTime;
    // private String rawData;
    private String module;
    private String serial;
    private Double frequency;
    private Double amplitude;
}
