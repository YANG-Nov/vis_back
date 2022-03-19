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
public enum AllEnum implements EnumConvert {
    //user
    DD("1448232280441845762", "大大"),
    XX("1448237380441845762", "小小"),
    FQY("1454087861940625409", "风清扬"),
    YY("1454092223404417025", "扬扬"),
    FF("1454093906989654017", "fangfang"),
    LX("1483436669192495106", "李欣"),
    ZYX("1483437112677228545", "曾阳夏"),
    JHX("1483437418882392065", "江鹤轩"),
    //TaskStatus
    WAIT_RECEIVE("1002000001", "待领取"),
    INSPECTING("1002000002", "正在巡检"),
    WAIT_REVIEW("1002000003", "待审核"),
    WAIT_DISTRIBUTE("1002000004", "待分配"),
    WAIT_RETRANSMIT("1002000005", "待重传"),
    FINISH("1002000006", "巡检完成"),
    AUTO_RECALL("1002000007", "自动召回"),
    MAN_RECALL("1002000008", "主动召回"),
    WAIT_INSPECTION("1002000009", "待巡检"),
    FIISH("1483436669192495106", "李欣"),
    WAIT_REVIEW_AGAIN("1002000010", "待重审"),
    RETRANSMIT("1003000001", "1002000003,1002000005,1002000010"),
    AMENDING_TASK("1004000001", "待修改任务页"),
    MANAGING_TASK("1004000002", "1002000001,1002000002,1002000003,1002000005,1002000006,1002000009"),
    //taskType
    DAILY_INSPECTION("1001000001", "日常巡检"),
    INTERVAL_INSPECTION("1001000002", "定期检查"),
    SPECIAL_INSPECTION("1001000003", "特殊检查"),
    MAINTENANCE("1001000004", "养护维修"),
    //frequency
    ONCE_A_DAY("2004000001", "1次/日"),
    ONCE_A_MONTH("2004000002", "1次/月"),
    ONCE_SIX_MONTH("2004000003", "1次/六月"),
    ONCE_A_YEAR("2004000004","1次/年");

    private String value;//key

    private String label;//name

    private static Map<String, AllEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(AllEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public EnumConvert[] getLabels() {

        return AllEnum.values();
    }

    AllEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(AllEnum::getLabel).orElse("");
    }

    public static AllEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }
}
