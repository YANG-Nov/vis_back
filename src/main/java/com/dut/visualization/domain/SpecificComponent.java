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
 * @ Date       ：Created in 3:11 下午 2022/5/19
 * @ Description：
 * @Version: $
 */
@Data
@TableName("vis_specific_component")
@NoArgsConstructor
@AllArgsConstructor
public class SpecificComponent {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @ApiModelProperty(value = "节段id")
    private String sectionId;

    @ApiModelProperty(value = "里程id")
    private String stationId;

    @ApiModelProperty(value = "构件id")
    private String componentId;

    @ApiModelProperty(value = "构件名称")
    private String componentName;

    @ApiModelProperty(value = "模型编码")
    private String modelCode;

    @ApiModelProperty(value = "构件功能")
    private String function;

    @ApiModelProperty(value = "建成时间")
    private String time;

    @ApiModelProperty(value = "施工单位")
    private String constructionUnit;

    @ApiModelProperty(value = "构件顺序值")
    private String orderNumber;

    @ApiModelProperty(value = "构件细部图纸等")
    private String document;

    @ApiModelProperty(value = "逻辑删除 1删0未删")
    @TableLogic
    private String isDeleted;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
