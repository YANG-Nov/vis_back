package com.dicadut.soms.enumeration;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2022-01-01 23:50:18
 */
public enum TaskStatusEnum {
    WAIT_RECEIVE("1001000001", "待领取"),
    INSPECTING("1001000002", "进行中"),
    WAIT_REVIEW("1001000003", "待审核"),
    WAIT_DISTRIBUTE("1001000004", "待分配"),
    WAIT_RETRANSMIT("1001000004", "待重传"),
    FINISH("1001000004", "已完成"),
    ;

    private String value;

    private String label;

    private static Map<String, TaskStatusEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(TaskStatusEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    TaskStatusEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(TaskStatusEnum::getLabel).orElse("");
    }

    public static TaskStatusEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }
}
