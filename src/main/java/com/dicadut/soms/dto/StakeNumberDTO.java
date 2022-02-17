package com.dicadut.soms.dto;

import com.dicadut.soms.json.StakeNumberDeserializer;
import com.dicadut.soms.json.StakeNumberSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @author fan_jennifer
 * @version 1.0
 * @date 2022-01-11 14:46
 */
@Data
public class StakeNumberDTO {
    private String id;

    @JsonSerialize(using = StakeNumberSerializer.class)
    @JsonDeserialize(using = StakeNumberDeserializer.class)
    private String number;
}
