package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 业务编码表
 * </p>
 *
 * @author Radium
 * @since 2022-01-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_business_code")
public class BusinessCode extends Model<BusinessCode> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 日期
     */
    private String codeDate;
    /**
     * 当前编码，每日从1开始计算
     */
    private Integer currentIndex;


}
