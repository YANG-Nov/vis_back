package com.dicadut.soms.util;


import com.dicadut.soms.dto.WyResDTO_qly;
import com.dicadut.soms.entity.Wy_qly;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yang
 * @Description TODO
 * @create 2021-08-25 17:10
 */
public class WyUtil_qly {
    public static List<WyResDTO_qly> convert(List<Wy_qly> wys) {
        return wys.stream().map(e -> {
            WyResDTO_qly dto = new WyResDTO_qly();
            // dto.setId(e.getId());
            dto.setSerial(e.getSerial()+"");
            dto.setGetTime(e.getGetTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            // dto.setLoraRawData(e.getLoraRawData() + " ");
            // dto.setWyRawData(e.getWyRawData() + " ");
            dto.setValue(e.getValue());
            return dto;
        }).collect(Collectors.toList());
    }
}
