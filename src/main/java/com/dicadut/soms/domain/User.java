package com.dicadut.soms.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Yang
 * @version 1.0.0
 * @create 2021-10-13 12:29
 */
@Data
@TableName("t_user")
public class User {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id", example = "23863422-8b51-4084-80b7-e419483f82b9")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    @ApiModelProperty(value = "账户名", example = "breeze")
    private String userName;
    @ApiModelProperty(value = "用户姓名", example = "风清扬")
    private String realName;
    @ApiModelProperty(value = "手机号", example = "18012345678")
    private String phone;
    @ApiModelProperty(value = "邮箱", example = "12345678@163.com")
    private String email;
    @ApiModelProperty(value = "密码", example = "b64f6@b*3d4b46!@1gd05#d4d4bgd04*2661bc@!3b010*56d!#gb61#5bdF1ga5")
    private String password;
    @ApiModelProperty(value = "头像", example = "Base64二进制数据，未来考虑换成OSS")
    private String headImg;
    @ApiModelProperty(value = "所属部门", example = "检测公司")
    private String department;
    @ApiModelProperty(value = "职务", example = "0管理员1养护工程师2巡检员3维修员", allowableValues = "0,1,2,3")
    private Integer duty = 0;
    @ApiModelProperty(value = "加密盐值")
    private String salt;
    @ApiModelProperty(value = "工作状态:工作中2001000001 空闲中2001000002", example = "2001000002", allowableValues = "2001000002,2001000001")
    private Integer status = 2001000002;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "是否已删除", example = "0", allowableValues = "0,1")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "创建时间", example = "2021-09-30 13:00:00")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间", example = "2021-09-30 14:00:00")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}
