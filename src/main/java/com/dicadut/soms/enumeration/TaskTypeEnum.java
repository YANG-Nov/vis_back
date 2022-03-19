package com.dicadut.soms.enumeration;


import com.dicadut.soms.dto.TypeNameDTO;

import java.util.*;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-12-31 16:50:18
 */
public enum TaskTypeEnum {
    DAILY_INSPECTION("1001000001", "日常巡检"),
    INTERVAL_INSPECTION("1001000002", "定期检查"),
    SPECIAL_INSPECTION("1001000003", "特殊检查"),
    MAINTENANCE("1001000004", "养护维修"),
    ;

    private String value;

    private String label;

    private static Map<String, TaskTypeEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(TaskTypeEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    TaskTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(TaskTypeEnum::getLabel).orElse("");
    }

    public static TaskTypeEnum getEnum(String value) {

        return codeEnumMap.get(value);
    }
    public static List<TypeNameDTO> getAllEnum(){
        List<TypeNameDTO> typeNameDTOs = new ArrayList<>();
        for (Map.Entry<String, TaskTypeEnum> entry : codeEnumMap.entrySet()) {
            TypeNameDTO typeNameDTO = new TypeNameDTO();
            typeNameDTO.setCode(entry.getKey());
            typeNameDTO.setCodeName(findByValue(entry.getKey()));
            typeNameDTOs.add(typeNameDTO);
        }
        return typeNameDTOs;
    }
}
