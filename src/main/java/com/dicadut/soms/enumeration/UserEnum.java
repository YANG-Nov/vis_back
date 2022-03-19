package com.dicadut.soms.enumeration;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-19 0:04
 */
public enum UserEnum {
    WAIT_RECEIVE("1448232280441845762", "大大"),
    INSPECTING("1448237380441845762", "小小"),
    WAIT_REVIEW("1454087861940625409", "风清扬"),
    WAIT_DISTRIBUTE("1454092223404417025", "扬扬"),
    WAIT_RETRANSMIT("1454093906989654017", "fangfang"),
    FINISH("1483436669192495106", "李欣"),
    AUTO_RECALL("1483437112677228545", "曾阳夏"),
    MAN_RECALL("1483437418882392065", "江鹤轩");

    private String value;//key

    private String label;//name

    private static Map<String, UserEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(UserEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }


    public String getValue() {
        return value;
    }


    public String getLabel() {
        return label;
    }


    UserEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(UserEnum::getLabel).orElse("");
    }

    public static UserEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }
}
