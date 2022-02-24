package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 任务套餐表
 * </p>
 *
 * @author fan_jane
 * @since 2022-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_task_set_menu")
@ApiModel(value="TaskSetMenu对象", description="任务套餐表")
@Deprecated
public class TaskSetMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增长逐渐id")
    @TableId
    private Long id;

    @ApiModelProperty(value = "套餐名称")
    private String name;

    @ApiModelProperty(value = "逻辑删除:0 未删，1 删除")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建人")//Jane_TODO 2022/2/24后期绑定
    private String creatBy;

    @ApiModelProperty(value = "修改人")//Jane_TODO 2022/2/24 后期绑定
    private String updateBy;

    @ApiModelProperty(value = "创建日期： 1000-01-01 00：00：00 ")
    private Date createTime;

    @ApiModelProperty(value = "修改日期： 1000-01-01 00：00：00 ")
    private Date updateTime;


}
