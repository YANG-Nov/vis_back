package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TBridgeInfo对象", description = "")
@TableName("system.t_bridge_info")
public class BridgeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "桥梁信息id")
    @TableId(type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "引桥为桩号，主桥为榀号")
    private String stakeOrTrussNumber;

    @ApiModelProperty(value = "匝道：1 A线， 2 B线， 3 S线， 4 X线")
    private String line;

    @ApiModelProperty(value = "主桥或引桥：1 东引桥，2 主桥 3 西引桥")
    private String mainOrApproach;

    @ApiModelProperty(value = "桥梁名称")
    private String bridgeName;

    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除:0 未删，1 删除")
    @TableLogic
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "所在匝道位置", example = "东引桥b匝道")
    private String location;
}
