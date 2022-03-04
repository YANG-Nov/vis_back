package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description 桥构建表，也叫构件编号
 * @date 2022-03-04 19:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_bridge_component")
public class BridgeComponent {
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 桥梁表桩号id
     */
    private String bridgeId;
    /**
     * 构件id
     */
    private String componentId;
    /**
     * 构件顺序
     */
    private String orderNumber;
    /**
     * 构件巡检位置
     */
    private String inspectionStakeNumber;
    /**
     * 构件巡检频率
     */
    private String inspectionFrequency;
    /**
     * 就近打卡点位置
     */
    private String scanPosition;

    @Version
    private Integer version;

    /**
     * 是否删除：0未删1删
     */
    @TableLogic
    private Boolean isDeleted;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

