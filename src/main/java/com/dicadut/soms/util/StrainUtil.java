package com.dicadut.soms.util;

import com.dicadut.soms.dto.StrainResDTO;
import com.dicadut.soms.entity.Strain;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-14 16:15:58
 */
public class StrainUtil {

    public static List<StrainResDTO> convert(List<Strain> strains) {
        return strains.stream().map(e -> {
            StrainResDTO dto = new StrainResDTO();
            // dto.setId(e.getId());
            // dto.setSendTime(e.getSendTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            dto.setGetTime(e.getGetTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            // dto.setRawData(e.getRawData());
            dto.setModule(e.getModule() + "");
            dto.setSerial(e.getSerial() + "");
            dto.setFrequency(e.getFrequency());
            dto.setAmplitude(e.getAmplitude());
            return dto;
        }).collect(Collectors.toList());
    }

}
