package com.dicadut.soms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-19 19:48
 */
@Data
public class TaskContentDTO {
    private String inspectionPosition;
    private List<ComponentNumberTotalDTO> children = new ArrayList<>();
}
