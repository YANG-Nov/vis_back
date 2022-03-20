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
public enum DiseaseUnitEnum {
    AREA("10101", "m²"),
    AMOUNT("10201", "个"),
    QUANTITY("10301", "处"),
    CRACK_LENGTH("10401", "mm"),
    CRACK_WIDTH("10501", "mm"),
    HIGH_QUALITY("10601", "mm"),
    SETTLEMENT_DEPTH("10701", "mm"),
    BREAKAGE_LENGTH("10801", "m"),
    BUCKLING_DEFORMATION("10901", "cm"),
    TELESCOPIC_WIDTH("11001", "cm"),
    LOWER_FLEXIBLE("11101", "mm"),
    LINER_DEFORMATION("11201", "m"),
    SLIP_AMOUNT("11301", "cm³"),
    LOSE_WEIGHT("11401", "cm³"),
    DEFLECTION("11501", "个"),
    DEPTH("11601", "mm"),
    TELESCOPIC_WIDTH1("11701", "cm"),
    BEND_DEFORMATION("11801", "mm"),
    BEARING_DEFORMATION("11901", "mm"),
    ACCUMULATED_AREA("12001", "m²"),
    TOTAL_AREA("12101", "m²"),
    BUCKLING_LENGTH("12201", "cm"),
    COMPONENT_AMOUNT("12301", "个");


    private String value;//key

    private String label;//name

    private static Map<String, DiseaseUnitEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(DiseaseUnitEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }


    public String getValue() {
        return value;
    }


    public String getLabel() {
        return label;
    }


    DiseaseUnitEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(DiseaseUnitEnum::getLabel).orElse("");
    }

    public static DiseaseUnitEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }
}
