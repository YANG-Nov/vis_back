package com.dicadut.soms.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 17:25:56
 */
@Data
public class WyResDTO {
      //private Integer id;
    private Long serial;
    private String getTime;
    //private String loraRawData;
    //private String wyRawData;
    private Double value;

}
