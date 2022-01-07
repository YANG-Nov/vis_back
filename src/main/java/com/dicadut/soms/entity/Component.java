package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/20 22:14
 */
@Data
@TableName("system.component")
public class Component {
    @ApiModelProperty(value = "自增长id")
    @TableId
    private Integer id;

    @ApiModelProperty(value = "构件编码，唯一索引，暂定先用uuid")
    private String code;

    @ApiModelProperty(value = "构件名称：构建类型+桩号+构件位置（桥面铺装A0）")
    private String codeName;

    @ApiModelProperty(value = "构件描述:对构建具体位置进行描述")
    private String componentDesc;

    @ApiModelProperty(value = "构件位置：数字为里程增大方向从左到右的顺序")
    private Integer componentPosition;

    @ApiModelProperty(value = "构件类型：2001000001 桥面铺装，2001000002 桥头平顺，2001000003 伸缩缝，2001000004 防撞护栏， 2001000005 排水管， 2001000006 排水口")
    private String componentType;

    @ApiModelProperty(value = "桥梁部位,：2003000001上部结构，  2003000002 下部结构， 2003000003 桥面系")
    private String bridgeComposition;

    @ApiModelProperty(value = "桩号")
    private String stakeNumber;

    @ApiModelProperty(value = "路线：3001000001 A线，3001000002 B线，3001000003 S线，3001000004 X线")
    private String line;

    @ApiModelProperty(value = "主桥, 引桥：2002000001 东引桥，2002000002 主桥，2002000003 西引桥")
    private String mainOrApproach;

    @ApiModelProperty(value = "构件材料：先放着")
    private String componentMaterial;

    @ApiModelProperty(value = "巡检频率：1003000001 一天一次，1003000002 每月一次 ，1003000003 六月一次， 1003000004 一年一次 ")
    @TableField("Inspection_frequency")
    private String inspectionFrequency;

    @ApiModelProperty(value = "逻辑删除:0 未删，1 删除")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建日期： 1000-01-01 00：00：00 ")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")//TODO 后期绑定
    private String creatBy;

    @ApiModelProperty(value = "修改日期： 1000-01-01 00：00：00 ")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "修改人")//TODO 后期绑定
    private String updateBy;

}

