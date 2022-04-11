package com.dicadut.soms.enumeration;


import com.dicadut.soms.dto.TypeNameDTO;

import java.util.*;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2022-01-01 23:50:18
 */
public enum ScanPositionEnum {
    ONE("4001000001", "S0侧隧道口"),
    TWO("4001000002", "S45塔柱"),
    THREE("4001000003", "S114栏杆"),
    FOR("4001000004", "X46塔柱"),
    FIVE("4001000005", "X110栏杆"),
    SIX("4001000006", "A0桥台"),
    SEVEN("4001000007", "A6盖梁");

    private String value;//key

    private String label;//name

    private static Map<String, ScanPositionEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(ScanPositionEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }


    ScanPositionEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(ScanPositionEnum::getLabel).orElse("");
    }

    public static String findByLabel(String label) {
        return Arrays.stream(values()).filter(e -> e.getLabel().equals(label)).findAny().map(ScanPositionEnum::getValue).orElse("");
    }

    public static ScanPositionEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }

    public static List<TypeNameDTO> getAllEnum(){
        List<TypeNameDTO> typeNameDTOs = new ArrayList<>();
        for (Map.Entry<String, ScanPositionEnum> entry : codeEnumMap.entrySet()) {
            TypeNameDTO typeNameDTO = new TypeNameDTO();
            typeNameDTO.setCode(entry.getKey());
            typeNameDTO.setCodeName(findByValue(entry.getKey()));
            typeNameDTOs.add(typeNameDTO);
        }
        return typeNameDTOs;
    }
}
