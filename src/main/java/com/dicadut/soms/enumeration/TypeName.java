package com.dicadut.soms.enumeration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc  TODO 待完善
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-06 21:32
 */
public enum TypeName {

    COMPONENT_INSPECTION_FREQUENCY("2004","构件巡检频率");

    private String value;

    private String label;

    private static Map<String, TypeName> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(TypeName.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    TypeName(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(TypeName::getLabel).orElse("");
    }

    public static TypeName getEnum(String value) {
        return codeEnumMap.get(value);
    }
}
