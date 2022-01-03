package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author testjava
 * @since 2022-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TDictionary对象", description="字典表")
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典id")
    @TableId
    private String id;

    @ApiModelProperty(value = "大类编码")
    private String type;

    @ApiModelProperty(value = "大类名称")
    private String typeName;

    @ApiModelProperty(value = "类型编码")
    private String code;

    @ApiModelProperty(value = "类型名称")
    private String codeName;

    @ApiModelProperty(value = "显示顺序")
    private Integer displayOrder;

    @ApiModelProperty(value = "状态 （0:正常 ，1:无效)")
    private Integer state;


}
