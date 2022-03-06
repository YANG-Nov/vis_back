package com.dicadut.soms.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

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
    private Map<String, String> inspectionComponentNumbers = new HashMap<>();

}
