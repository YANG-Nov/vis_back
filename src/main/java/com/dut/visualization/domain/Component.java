package com.dut.visualization.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 2:40 下午 2022/5/19
 * @ Description：构件
 * @Version: $
 */
@Data
@TableName("vis_component")
@NoArgsConstructor
@AllArgsConstructor
public class Component {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "构件id")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "构件名称")
    private String name;

    @ApiModelProperty(value = "材料")
    private String material;

    @ApiModelProperty(value = "构件所在树形结构层级")
    private String level;

    @ApiModelProperty(value = "父构件id")
    private String parentId;

    @ApiModelProperty(value = "父构件名称")
    private String parentName;

    @ApiModelProperty(value = "id路径")
    private String xpath;

    @ApiModelProperty(value = "name路径")
    private String xname;

    @ApiModelProperty(value = "逻辑删除 1删0未删")
    @TableLogic
    private String isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
