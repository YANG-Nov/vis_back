package com.dut.visualization.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DiseaseInfoHistoryListDTO {
    private String diseaseName;
    private String diseaseAttribute;
    private List<Data> diseaseAttributeData = new ArrayList<>();

    @lombok.Data
    public static class Data {
        private String data;
        private String createTime;
    }

    public static List<DiseaseInfoHistoryListDTO> convert(List<DiseaseInfoHistoryDTO> diseaseInfoHistoryDTOList) {

        Map<String, DiseaseInfoHistoryListDTO> map = new HashMap<>();

        for (DiseaseInfoHistoryDTO diseaseInfoHistoryDTO : diseaseInfoHistoryDTOList) {
            String key = String.format("%s-%s", diseaseInfoHistoryDTO.getDiseaseName(), diseaseInfoHistoryDTO.getDiseaseAttribute());
            if (!map.containsKey(key)) {
                DiseaseInfoHistoryListDTO diseaseInfoHistoryListDTO = new DiseaseInfoHistoryListDTO();
                diseaseInfoHistoryListDTO.setDiseaseName(diseaseInfoHistoryDTO.getDiseaseName());
                diseaseInfoHistoryListDTO.setDiseaseAttribute(diseaseInfoHistoryDTO.getDiseaseAttribute());
                map.put(key, diseaseInfoHistoryListDTO);
            }

            Data data = new Data();
            data.setData(diseaseInfoHistoryDTO.getData());
            data.setCreateTime(diseaseInfoHistoryDTO.getCreateTime());
            map.get(key).getDiseaseAttributeData().add(data);
        }

        return new ArrayList<>(map.values());
    }
}
