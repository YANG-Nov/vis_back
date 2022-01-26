package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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
@TableName("system.t_disease_record")
public class DiseaseRecord extends Model<DiseaseRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 任务编号
     */
    private String taskId;
    /**
     * 构件id
     */
    private String componentId;
    /**
     * 桥桩号id
     */
    private String bridgeInfoId;
    /**
     * 病害种类id
     */
    private String diseaseId;
    /**
     * 病害记录种类：(1)输入框,(2)下拉框,(3)单选框,(4)照片/视频,(5)语音,(6)文本
     */
    private Integer type;
    /**
     * 病害属性id
     */
    private String diseaseAttributeId;
    /**
     * 病害记录内容
     */
    private String content;

}
