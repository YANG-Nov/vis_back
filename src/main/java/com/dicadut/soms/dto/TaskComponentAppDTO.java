package com.dicadut.soms.dto;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:46 下午 2022/3/4
 * @ Description：添加病害前，选择构件列表
 * @Version: 1.0.0$
 */
@Data
public class TaskComponentAppDTO {
    private String inspectionLocation;
    private List<Item> componentList;

    @Data
    public static class Item{
        private String componentId;
        private String component;
    }
}
