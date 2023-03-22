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

    @ApiModelProperty(value = "隧道长度")
    private String length;

    @ApiModelProperty(value = "养护等级")
    private String maintenanceGrade;

    @ApiModelProperty(value = "建成时间")
    private String finishTime;

    @ApiModelProperty(value = "隧道编码")
    private String code;

    @ApiModelProperty(value = "隧道类型")
    private String type;

    @ApiModelProperty(value = "业主单位")
    private String ownerUnit;

    @ApiModelProperty(value = "设计单位")
    private String designUnit;

    @ApiModelProperty(value = "施工单位")
    private String constructionUnit;

    @ApiModelProperty(value = "监理单位")
    private String supervisionUnit;

    @ApiModelProperty(value = "养护单位")
    private String maintenanceUnit;

    @ApiModelProperty(value = "道路名称")
    private String roadName;

    @ApiModelProperty(value = "道路等级")
    private String roadGrade;

    @ApiModelProperty(value = "工程概况")
    private String introduction;

    @ApiModelProperty(value = "逻辑删除 1删0未删")
    @TableLogic
    private String isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
