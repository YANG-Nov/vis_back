package com.dut.visualization.dto;

import lombok.Data;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:47 下午 2023/10/12
 * @ Description：单个病害详情（病害历史）
 * @Version: 1.0.0$
 */
@Data
public class DiseaseInfoHistoryDTO {

    private String diseaseName;
    private String diseaseAttribute;
    private String data;
    private String createTime;

}
