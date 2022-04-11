package com.dicadut.soms.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-09-30 17:47:26
 */
@ApiModel("系统用户")
@Data
public class UserDTO {
    @ApiModelProperty(value = "用户id", example = "23863422-8b51-4084-80b7-e419483f82b9")
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
    @ApiModelProperty(value = "创建时间")   //, example = "2021-09-30 13:00:00")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")   //, example = "2021-09-30 14:00:00")
    private Date updateTime;
    @ApiModelProperty(value = "是否已删除", example = "0", allowableValues = "0,1")
    private Integer isDelete = 0;
    @ApiModelProperty(value = "工作状态:工作中2001000001 空闲中2001000002", example = "2001000002", allowableValues = "2001000002,2001000001")
    private Integer status = 2001000002;
}
