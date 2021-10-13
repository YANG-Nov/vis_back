package com.dicadut.soms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dicadut.soms.dto.UserDTO;
import com.dicadut.soms.mapper.UserDTOMapper;
import com.dicadut.soms.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Yang
 * @Description TODO
 * @create 2021-10-12 13:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDTOMapper, UserDTO> implements UserService {


}
