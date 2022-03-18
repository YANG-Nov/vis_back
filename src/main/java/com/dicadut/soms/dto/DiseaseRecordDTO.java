package com.dicadut.soms.dto;


import lombok.Data;

import java.util.List;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2022-01-26 23:19:21
 */
@Data
public class DiseaseRecordDTO {

//    {
//        taskId:"111",
//        componentId:"222",
//        positionId:"333",
//        diseaseId:"444",
//        featureField: [{id:10301,   content:5,type:1},{id:10401, content:56,type:1}],                        2
//        featurePopup: [{id:20101,  type:2},{id:20202,type:2}],                                               2
//        featureRadio: [{id:30102,  type:3},{id:30101,type:3}],                                               2
//        diseasePicture: [{content:"http:abc/dbc.img"  type:4},{content:"http:abc/dbc.mp4"  type:4}],         2
//        diseaseVoice: [{content:"http:abc/dbc.wav"  type:5}],                                                1
//        diseaseText: [{content:"病害描述"  type:6}]                                                            1
//    }

    private String taskId;
    private String componentId;
    private String positionId;
    private String diseaseId;
    private List<Item> featureFields;
    private List<Item> featurePopups;
    private List<Item> featureRadios;
    private List<Item> diseasePictures;
    private List<Item> diseaseVideos;
    private List<Item> diseaseVoices;
    private List<Item> diseaseTexts;


//    private List<Item> diseaseList;


    @Data
    public static class Item {
        private Integer type;                   // 病害记录种类：(1)输入框,(2)下拉框,(3)单选框,(4)照片/视频,(5)语音,(6)文本
        private String diseaseAttributeId;
        private String content;
    }

}
