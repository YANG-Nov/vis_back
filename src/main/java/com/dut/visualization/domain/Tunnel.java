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
 * @ Date       ：Created in 10:11 上午 2022/5/5
 * @ Description：隧道信息表
 * @Version: 1$
 */
@Data
@TableName("vis_tunnel")
@NoArgsConstructor
@AllArgsConstructor
public class Tunnel {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "隧道编号")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "隧道名称")
    private String name;

    @ApiModelProperty(value = "业主单位")
    private String ownerUnit;

    @ApiModelProperty(value = "设计单位")
    private String designUnit;

    @ApiModelProperty(value = "施工单位")
    private String constructionUnit;

    @ApiModelProperty(value = "监理单位")
    private String supervisionUnit;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "逻辑删除 1删0未删")
    @TableLogic
    private String isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
