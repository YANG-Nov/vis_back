package com.dicadut.soms.util;

import com.dicadut.soms.dto.StrainResDTO;
import com.dicadut.soms.dto.WyResDTO;
import com.dicadut.soms.entity.Strain;
import com.dicadut.soms.entity.Wy;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-14 16:15:58
 */
public class WyUtil {

    public static List<WyResDTO> convert(List<Wy> wys) {
        return wys.stream().map(e -> {
            WyResDTO dto = new WyResDTO();
            // dto.setId(e.getId());
            dto.setSerial(e.getSerial());
            dto.setGetTime(e.getGetTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            // dto.setLoraRawData(e.getLoraRawData() + " ");
            // dto.setWyRawData(e.getWyRawData() + " ");
            dto.setValue(e.getValue());

            return dto;
        }).collect(Collectors.toList());
    }

}
