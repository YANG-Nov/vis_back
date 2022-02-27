package com.dicadut.soms.dto;

import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 12:21 下午 2022/1/27
 * @ Description：App添加病害后,添加病害页显示病害记录
 * @Version: 1.0.0$
 */
@Data
public class DiseaseRecordAppListDTO {
    @ApiModelProperty("任务id")
    private String taskId;
    @ApiModelProperty("病害名称")
    private String disease;
    @ApiModelProperty("病害id")
    private String diseaseId;
    @ApiModelProperty("病害位置")
    @JsonSerialize(using = StakeNumberSerializer.class)
    @JsonDeserialize(using = StakeNumberDeserializer.class)
    private String position;
    @ApiModelProperty("病害id")
    private String positionId;

    private List<Item> featureFields = new ArrayList<>();
    private List<Item> featurePopups = new ArrayList<>();
    private List<Item> featureRadios = new ArrayList<>();
    private List<Item> diseasePictures = new ArrayList<>();
    private List<Item> diseaseVoices = new ArrayList<>();
    private List<Item> diseaseTexts = new ArrayList<>();
    @Data
    public class Item {
        @ApiModelProperty(value = "病害属性id")
        private String diseaseAttributeId;
        @ApiModelProperty(value = "病害属性")
        private String diseaseAttributeName;
        @ApiModelProperty(value = "内容")
        private String content;
        @ApiModelProperty(value = "内容种类")
        private String type;
    }
}
