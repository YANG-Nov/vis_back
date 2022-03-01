package com.dicadut.soms.enumeration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-06 21:32
 */
public enum TypeNameEnum {

    COMPONENT_INSPECTION_FREQUENCY("2004", "构件巡检频率"),
    TASK_TYPE("1001", "任务类型"),
    B_LINE_STAKE_NUMBER("3002", "B匝道桩号数"),
    SCAN_POSITION("4001","打卡点");

    private String value;

    private String label;

    private static Map<String, TypeNameEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(TypeNameEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    TypeNameEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(TypeNameEnum::getLabel).orElse("");
    }

    public static TypeNameEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }
}
