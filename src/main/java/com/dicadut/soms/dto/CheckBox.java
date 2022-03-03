package com.dicadut.soms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description 返回勾选框的数据
 * @date 2022-03-01 20:24
 */
@Data
public class CheckBox<T> {
    private List<T> option = new ArrayList<>();
    @JsonProperty("default")
    private List<String> selected = new ArrayList<>();

}
