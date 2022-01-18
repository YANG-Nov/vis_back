package com.dicadut.soms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dicadut.soms.dto.UserStatusDTO;
import com.dicadut.soms.domain.User;

import java.util.List;

/**
 * @author Yang
 * @Description TODO
 * @create 2021-10-12 13:52
 */
public interface UserService extends IService<User> {

    List<UserStatusDTO> getStatusMaintainerList();
    List<UserStatusDTO> getStatusInspectorList();

}
