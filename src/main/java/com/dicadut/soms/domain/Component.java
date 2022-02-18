package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author fan_jennifer
 * @create 2021-11-2021/11/20 22:14
 */
@Data
@TableName("t_component")
public class Component {
    @ApiModelProperty(value = "构件id")
    private Integer id;

    @ApiModelProperty(value = "构件名称（类型）")
    private String name;

    @ApiModelProperty(value = "构件父id")
    private Integer parentId;

    @ApiModelProperty(value = "父子关系层级")
    private Integer level;

    @ApiModelProperty(value = "父子关系树路径id")
    private String xpath;

    @ApiModelProperty(value = "父子关系树名称")
    private String xname;

    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除:0 未删，1 删除")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建日期： 1000-01-01 00：00：00 ")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改日期： 1000-01-01 00：00：00 ")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}

