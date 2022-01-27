package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 任务桥构件表
 * </p>
 *
 * @author Auto-generator
 * @since 2022-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("system.t_task_bridge_component")
public class TaskBridgeComponent extends Model<TaskBridgeComponent> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 桥梁构件关联id
     */
    private Integer bridgeComponentId;
    /**
     * 是否删除：0未删1删
     */
    private Boolean isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}
