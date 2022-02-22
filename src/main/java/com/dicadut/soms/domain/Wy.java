package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Yang
 * @create 2021-08-25 16:59
 */
@Data
@TableName("dalianwan.wy")
public class Wy {
    @TableId
    private Integer id;
    private Integer serial;
    private LocalDateTime getTime;
    private String loraRawData;
    private String wyRawData;
    private Double value;
}
