package com.dicadut.soms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-04-04 11:30
 */
@Data
public class TaskDiseaseReviewVO {

    private List<TaskDiseaseReviewVO.Item> text;
    private List<TaskDiseaseReviewVO.Item> media;
    private Integer recordId;


    @Data
    @AllArgsConstructor
    public static class Item {
        private String label;
        private Object value ;
    }

}

