package com.dut.visualization.controller;

import com.dut.visualization.dto.UserInfoDTO;
import com.dut.visualization.dto.UserLoginDTO;
import com.dut.visualization.viewmodel.ResponseViewModel;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：Yang
 * @ Date       ：Created in 3:46 下午 2022/5/10
 * @ Description：模拟登录
 * @Version: $
 */
@Api(tags = "用户接口")
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    //login
    @PostMapping("login")
    public ResponseViewModel login(){
        String Token = "admin";
        return ResponseViewModel.ok(Token);
    }

    //info
    @GetMapping("info")
    public ResponseViewModel info(){
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setName("admin");
        userInfoDTO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return ResponseViewModel.ok(userInfoDTO);
    }

}

