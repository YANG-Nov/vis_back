package com.dicadut.soms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dicadut.soms.domain.User;
import com.dicadut.soms.dto.UserPermissionDTO;

import java.util.List;

/**
 * @author Yangø¬
 * @Description
 * @create 2021-10-12 13:54
 */
public interface UserMapper extends BaseMapper<User> {
    void updateUserStatus(String userId, String userStatusGo);

    List<UserPermissionDTO> queryUserPermissionByName(String userName);

    List<UserPermissionDTO> queryUserPermissionByMobile(String mobile);
}
