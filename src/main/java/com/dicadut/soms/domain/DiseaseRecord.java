package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 病害记录表
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_disease_record")
public class DiseaseRecord extends Model<DiseaseRecord> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "任务编号")
    private String taskId;

    @ApiModelProperty(value = "构件id")
    private String componentId;

    @ApiModelProperty(value = "桥桩号id")
    private String bridgeId;

    @ApiModelProperty(value = "构件编号")
    private Integer orderNumber;

    @ApiModelProperty(value = "病害种类id")
    private String diseaseId;

    @ApiModelProperty(value = "该条任务下病害记录id")
    private Integer recordId;

    @ApiModelProperty(value = "病害记录种类：(1)输入框,(2)下拉框,(3)单选框,(4)照片/视频,(5)语音,(6)文本")
    private Integer type;

    @ApiModelProperty(value = "病害属性id")
    private String diseaseAttributeId;

    @ApiModelProperty(value = "病害记录内容")
    private String content;

    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
