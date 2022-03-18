package com.dicadut.soms.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 5:00 下午 2022/2/27
 * @ Description：回显病害详情
 * @Version: 1.0.0$
 */
@Data
public class DiseaseDetailDTO {
    private List<DiseaseDetailListDTO> featureFields = new ArrayList<>();
    private List<DiseaseDetailListDTO> featurePopups = new ArrayList<>();
    private List<DiseaseDetailListDTO> featureRadios = new ArrayList<>();
    private List<DiseaseDetailListDTO> diseasePictures = new ArrayList<>();
    private List<DiseaseDetailListDTO> diseaseVideos = new ArrayList<>();
    private List<DiseaseDetailListDTO> diseaseVoices = new ArrayList<>();
    private List<DiseaseDetailListDTO> diseaseTexts = new ArrayList<>();
    private List<DiseaseDetailListDTO> diseaseReviewOpinion = new ArrayList<>();
}
