package com.dicadut.soms.vo;

import lombok.Data;

import java.util.List;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-04-23 23:57
 */
@Data
public class UserPermissionVO {
    private String id;

    private String userName;

    private String userPass;

    private String headImg;

    private Integer roleId;

    private String roleName;

    private List<String> permissions;

    private List<String> Path;
}
