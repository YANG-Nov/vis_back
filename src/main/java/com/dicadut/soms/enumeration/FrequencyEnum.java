package com.dicadut.soms.enumeration;

import com.dicadut.soms.dto.TypeNameDTO;

import java.util.*;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-06 21:32
 */
public enum FrequencyEnum {

    ONCE_A_DAY("2004000001", "1次/日"),
    ONCE_A_MONTH("2004000002", "1次/月"),
    ONCE_SIX_MONTH("2004000003", "1次/六月"),
    ONCE_A_YEAR("2004000004","1次/年");


    private String value;

    private String label;

    private static Map<String, FrequencyEnum> codeEnumMap = new HashMap<>();

    static {
        Arrays.asList(FrequencyEnum.values()).forEach(v -> {
            codeEnumMap.put(v.value, v);
        });
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    FrequencyEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }


    public static String findByValue(String value) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(value)).findAny().map(FrequencyEnum::getLabel).orElse("");
    }

    public static FrequencyEnum getEnum(String value) {
        return codeEnumMap.get(value);
    }
    public static List<TypeNameDTO> getAllEnum(){
        List<TypeNameDTO> typeNameDTOs = new ArrayList<>();
        for (Map.Entry<String, FrequencyEnum> entry : codeEnumMap.entrySet()) {
            TypeNameDTO typeNameDTO = new TypeNameDTO();
            typeNameDTO.setCode(entry.getKey());
            typeNameDTO.setCodeName(findByValue(entry.getKey()));
            typeNameDTOs.add(typeNameDTO);
        }
        return typeNameDTOs;
    }
}
