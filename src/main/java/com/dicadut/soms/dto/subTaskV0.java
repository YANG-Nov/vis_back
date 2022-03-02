package com.dicadut.soms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-02 14:49
 */
@Data
public class subTaskV0 {
    private String inspectionPosition;
    private String inspectionRoute;
    private List<String> inspectionComponentNumber = new ArrayList<>();

}
