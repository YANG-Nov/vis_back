package com.dicadut.soms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Yang
 * @Description TODO
 * @create 2021-10-12 14:44
 */
@Data
@TableName("system.user")
public class User {
    @TableId
    private String id;
    private String username;
    private String realName;
    private String phone;
    private String email;
    private String password;
    private String headImg;
    private String department;
    private Integer isAdministrator = 0;
    private Integer isInspector = 0;
    private Integer isMaintainer = 0;
    private Date createTime;
    private Date updateTime;
    private Integer isDelete = 0;
}
