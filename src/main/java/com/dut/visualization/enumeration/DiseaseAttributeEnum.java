package com.dut.visualization.enumeration;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-03-19 0:04
 */
public enum DiseaseAttributeEnum {
    AREA("10101", "面积"),
    AMOUNT("10201", "数量"),
    QUANTITY("10301", "数量"),
    CRACK_LENGTH("10401", "裂缝长度"),
    CRACK_WIDTH("10501", "裂缝宽度"),
    HIGH_QUALITY("10601", "高差"),
    SETTLEMENT_DEPTH("10701", "沉降深度"),
    BREAKAGE_LENGTH("10801", "破损长度"),
    BUCKLING_DEFORMATION("10901", "翘曲变形量"),
    TELESCOPIC_WIDTH("11001", "伸缩缝宽"),
    LOWER_FLEXIBLE("11101", "下挠值"),
    LINER_DEFORMATION("11201", "线形变形量"),
    SLIP_AMOUNT("11301", "滑移量"),
    LOSE_WEIGHT("11401", "损失量"),
    DEFLECTION("11501", "挠度值"),
    DEPTH("11601", "深度"),
    TELESCOPIC_WIDTH1("11701", "伸缩缝宽"),
    BEND_DEFORMATION("11801", "弯曲变形量"),
    BEARING_DEFORMATION("11901", "支座变形量"),
    ACCUMULATED_AREA("12001", "累计面积"),
    TOTAL_AREA("12101", "总面积"),
    BUCKLING_LENGTH("12201", "翘曲长度"),
    COMPONENT_AMOUNT("12301", "构件数"),
    EXTENT("2", "程度"),
    JUDGE("3", "判断"),
    Other_Disc("7", "其他描述");



    private String value;//key

    private String label;//name

    private static Map<String, DiseaseAttributeEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(DiseaseAttributeEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }


    public String getValue() {
        return value;
    }


    public String getLabel() {
        return label;
    }


    DiseaseAttributeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(DiseaseAttributeEnum::getLabel).orElse("");
    }

    public static DiseaseAttributeEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }
}
