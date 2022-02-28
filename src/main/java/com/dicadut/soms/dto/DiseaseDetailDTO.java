package com.dicadut.soms.dto;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 5:00 下午 2022/2/27
 * @ Description：回显病害详情
 * @Version: 1.0.0$
 */
@Data
public class DiseaseDetailDTO {

    private List<Item> featureFields;
    private List<Item> featurePopups;
    private List<Item> featureRadios;
    private List<Item> diseasePictures;
    private List<Item> diseaseVoices;
    private List<Item> diseaseTexts;

    @Data
    public static class Item {
        private String content;
        private String diseaseAttributeId;
        private String name;
        private Integer type;                   // 病害记录种类：(1)输入框,(2)下拉框,(3)单选框,(4)照片/视频,(5)语音,(6)文本
        private String unit;
        private String value;
    }
}
