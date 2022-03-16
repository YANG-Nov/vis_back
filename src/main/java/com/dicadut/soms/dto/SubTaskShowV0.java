package com.dicadut.soms.dto;

import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-02 14:49
 */
@Data
public class SubTaskShowV0 {
    private String inspectionPosition;
    private String inspectionRoute;
    private String inspectionStart;
    private String inspectionEnd;
    private String[] selectedComponents;
}
