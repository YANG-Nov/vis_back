package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 17:25:56
 */
@Data
public class Wy {
    @TableId
    private Integer id;
    private Long serial;
    private LocalDateTime getTime;
    private String loraRawData;
    private String wyRawData;
    private Double value;

}
