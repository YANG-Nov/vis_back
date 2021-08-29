package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 17:25:56
 */
@Data
@TableName("beidaqiao.strain")
public class Strain {
    @TableId
    private Integer id;
    private LocalDateTime sendTime;
    private LocalDateTime getTime;
    private String rawData;
    private Integer module;
    private Integer serial;
    private Double frequency;
    private Double amplitude;
}
