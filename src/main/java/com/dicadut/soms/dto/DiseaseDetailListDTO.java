package com.dicadut.soms.dto;

import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 10:06 上午 2022/2/28
 * @ Description：从数据库中查出病害详情
 * @Version: 1.0.0$
 */
@Data
public class DiseaseDetailListDTO {
    private String name;
    private String content;
    private String value;
    private String diseaseAttributeId;
    private Integer type;
    private String unit;
}