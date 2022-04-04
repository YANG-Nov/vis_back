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
    WAIT_RECEIVE("1002000001", "待领取"),
    INSPECTING("1002000002", "正在巡检"),
    WAIT_REVIEW("1002000003", "待审核"),
    WAIT_DISTRIBUTE("1002000004", "待分配"),
    WAIT_RETRANSMIT("1002000005", "待重传"),
    FINISH("1002000006", "巡检完成"),
    AUTO_RECALL("1002000007", "自动召回"),
    MAN_RECALL("1002000008", "主动召回"),
    WAIT_INSPECTION("1002000009", "待巡检"),
    WAIT_REVIEW_AGAIN("1002000010", "待重审"),

    RETRANSMIT("1003000001", "1002000003,1002000005,1002000010"),
    AMENDING_TASK("1004000001", "待修改任务页"),
    MANAGING_TASK("1004000002", "1002000001,1002000002,1002000003,1002000005,1002000009,1002000010")
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
