package com.dicadut.soms.dto;

import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 10:19 上午 2022/3/2
 * @ Description：病害记录表展示
 * @Version: 1.0.0$
 */
@Data
public class DiseaseRecordTableDTO {
    private String inspectionLocation;
    private List<Item> diseaseRecord;

    @Data
    public static class Item{
        private String taskId;
        private String componentId;
        private String component;
        private String positionId;
        @JsonSerialize(using = StakeNumberSerializer.class)
        @JsonDeserialize(using = StakeNumberDeserializer.class)
        private String position;
        private String diseaseId;
        private String disease;
    }
}
