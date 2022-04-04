package com.dicadut.soms.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-04-04 19:38
 */
@Data
public class OpinionVO {
    private String taskId;
    private String otherOpinion;
    private Map<Integer,String> reviewOpinions = new HashMap();
}
