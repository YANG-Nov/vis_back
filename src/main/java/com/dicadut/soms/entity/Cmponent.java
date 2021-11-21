package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/20 22:14
 */
@Data
@TableName("system.component")
public class Cmponent {
    @ApiModelProperty(value = "构件id")
    @TableId
    private String id;
    @ApiModelProperty(value = "构件名称")
    private String name;
    @ApiModelProperty(value = "构件编号")
    private String serialNumber;
    @ApiModelProperty(value = "构件等级：A每日/次:3001000001 B每月/次 3001000002 C三月/次 3001000003 D半年/次 " +
            "30010000004 E一年/次 30010000005巡检完成 ")
    private String componentLevel;
    @ApiModelProperty(value = "是否是打卡点", example = "1", allowableValues = "0,1")
    private Integer isScan = 0;
    @ApiModelProperty(value = "父id")
    private String parentId;
    @ApiModelProperty(value = "构件状态： ")
    private String componentStatus;
    @ApiModelProperty(value = "构件材料属性： ")
    private String material;
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;
}

