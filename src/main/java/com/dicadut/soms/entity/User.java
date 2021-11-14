package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Yang
 * @version 1.0.0
 * @create 2021-10-13 12:29
 */
@Data
@TableName("system.user")
public class User {
    @ApiModelProperty(value = "用户id", example = "23863422-8b51-4084-80b7-e419483f82b9")
    private String id;
    @ApiModelProperty(value = "账户名", example = "breeze")
    private String username;
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
    @ApiModelProperty(value = "创建时间", example = "2021-09-30 13:00:00")
    private Date createTime;
    @ApiModelProperty(value = "更新时间", example = "2021-09-30 14:00:00")
    private Date updateTime;
    @ApiModelProperty(value = "是否已删除", example = "0", allowableValues = "0,1")
    private Integer isDelete = 0;
    @ApiModelProperty(value = "工作状态", example = "0", allowableValues = "0,1")
    private Integer status = 0;
}
