package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-17 15:46
 */
@Data
@ApiModel("传给前端匝道和匝道包含的桩号")
public class LineLocationVO {
    private String value;
    private String label;
    private List<StakeNumberDTO> children = new ArrayList<>();
}
