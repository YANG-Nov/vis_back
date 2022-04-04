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
public enum DiseaseRecordTypeEnum {
    FEATURE_FIELD("1", "输入框"),
    FEATURE_POPUP("2", "下拉框"),
    FEATURE_RADIO("3", "单选框"),
    DISEASE_PICTURE("4", "病害照片"),
    DISEASE_VIDEO("5", "视频信息"),
    DISEASE_VOICE("6", "语音信息"),
    DISEASE_TEXT("7", "其它描述"),
    DISEASE_REVIEW_OPINION("8", "审核意见");


    private String value;//key

    private String label;//name

    private static Map<String, DiseaseRecordTypeEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(DiseaseRecordTypeEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }


    public String getValue() {
        return value;
    }


    public String getLabel() {
        return label;
    }


    DiseaseRecordTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(DiseaseRecordTypeEnum::getLabel).orElse("");
    }

    public static DiseaseRecordTypeEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }
}
