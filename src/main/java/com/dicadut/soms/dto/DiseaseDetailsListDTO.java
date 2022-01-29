package com.dicadut.soms.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 8:57 上午 2022/1/29
 * @ Description：APP添加病害后，查看病害详情
 * @Version: 1.0.0$
 */
@ApiModel("APP添加病害后，查看病害详情")
@Data
public class DiseaseDetailsListDTO {
    private List<DiseaseDetailsDTO> featureFields = new ArrayList<>();
    private List<DiseaseDetailsDTO> featurePopups = new ArrayList<>();
    private List<DiseaseDetailsDTO> featureRadios = new ArrayList<>();
    private List<DiseaseDetailsDTO> diseasePictures = new ArrayList<>();
    private List<DiseaseDetailsDTO> diseaseVoices = new ArrayList<>();
    private List<DiseaseDetailsDTO> diseaseTexts = new ArrayList<>();
}
