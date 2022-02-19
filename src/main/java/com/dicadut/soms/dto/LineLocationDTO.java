package com.dicadut.soms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-17 15:46
 */
@Data
public class LineLocationDTO {
    private String value;
    private String label;
    private List<StakeNumberDTO> children = new ArrayList<>();
}
