package com.dicadut.soms.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-04-23 23:47
 */
@Data
public class UserPermissionDTO {

    private String id;

    private String userName;

    private String userPass;

    private String headImg;

    private Integer roleId;

    private String roleName;

    private String phone;

    private String permissionCode;

    private String Path;


}
