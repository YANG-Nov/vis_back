package com.dicadut.soms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-11 15:35
 */
@Data
public class BridgeCompositionDTO {
    private String id;
    private String name;
    private List<ComponentDTO> children = new ArrayList<>();
}
