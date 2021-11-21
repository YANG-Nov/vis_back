package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2021-11-21
 */
@Data
@TableName("system.disease")
@NoArgsConstructor
@AllArgsConstructor
public class Disease{


    @ApiModelProperty(value = "病害id")
    @TableId
    private String id;

    @ApiModelProperty(value = "构件名")
    private String componentName;

    @ApiModelProperty(value = "是否完好")
    private Integer isGood;

    @ApiModelProperty(value = "损伤类型")
    private String damageType;

    @ApiModelProperty(value = "损伤程度")
    private String damageExtent;

    @ApiModelProperty(value = "损伤位置")
    private String damagePosition;

    @ApiModelProperty(value = "注释")
    private String Note;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
