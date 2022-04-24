package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.UserStatusDTO;
import com.dicadut.soms.domain.User;
import com.dicadut.soms.vo.UserPermissionVO;

import java.util.List;

/**
 * @author Yang
 * @Description
 * @create 2021-10-12 13:52
 */
public interface UserService extends IService<User> {

    List<UserStatusDTO> getStatusMaintainerList();
    List<UserStatusDTO> getStatusInspectorList();

    void updateUserStatus(String userId, String userStatusGo);

    /**
     * // Jane_TODO add description
     * @author FanJane
     * @param mobile
     * @return com.dicadut.soms.domain.User
     */
    UserPermissionVO queryUserByMobile(String mobile);

    /**
     * // Jane_TODO add description
     * @author FanJane
     * @param username
     * @return com.dicadut.soms.domain.User
     */
    UserPermissionVO queryUserPermissionByName(String userName);
}
