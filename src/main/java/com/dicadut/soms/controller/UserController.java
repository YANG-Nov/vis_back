package com.dicadut.soms.controller;


import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.common.Result;
import com.dicadut.soms.dto.UserDTO;
import com.dicadut.soms.entity.User;
import com.dicadut.soms.service.UserService;
import com.dicadut.soms.token.JwtToken;
import com.dicadut.soms.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Radium
 * @version 1.0.0
 * @date 2021-09-30 18:13:41
 */
@Api(tags = "用户管理接口")
@Slf4j
@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResponseViewModel<UserDTO> register(@RequestBody UserDTO userDTO) {
        log.info("用户注册 {}", userDTO);

        ResponseViewModel<UserDTO> responseViewModel = new ResponseViewModel<>();
        User user = new User();
        BeanUtil.copyProperties(userDTO, user);
        userService.save(user);
        return ResponseViewModel.ok(userDTO);

    }
    @ApiOperation("用户名是否已存在")
    @PostMapping("/isExist")
    public ResponseViewModel<UserDTO> iSExist(@RequestBody UserDTO userDTO) {
        User one = userService.getOne(new QueryWrapper<User>().eq("username", userDTO.getUsername()));

        if (one == null) {
            return ResponseViewModel.ok(userDTO);
        }else {
            return ResponseViewModel.fail("用户名已存在");
        }
    }


    @ApiOperation("重置密码")
    @PutMapping("/reset_password/{userId}/{password}")
    public ResponseViewModel<Integer> resetPassword(@PathVariable("userId") String userId,
                                                    @PathVariable("password") String password) {
        log.info("重置密码 {} {}", userId, password);

        // TODO 实现重置密码

        return ResponseViewModel.ok(1);
    }

    @ApiOperation("头像更新")
    @PutMapping("/update_head_img/{userId}/{head_img}")
    public ResponseViewModel<Integer> updateHeadImg(@PathVariable("userId") String userId,
                                                    @PathVariable("headImg") String headImg) {
        log.info("头像更新 {} {}", userId, headImg);

        // TODO 实现头像更新

        return ResponseViewModel.ok(1);
    }

    @ApiOperation("账号登陆")
    @PostMapping("/login/username")
    public String loginUserName(@RequestBody UserDTO userDTO) {
        log.info("用户登陆 {}", userDTO);

        // TODO 实现登陆
        Subject subject = SecurityUtils.getSubject();
        String jwt = JwtUtil.createJWT(userDTO.getUsername(),"back","user",1000*60*30);

        JwtToken jwtToken = new JwtToken(jwt, userDTO.getPassword());
        try {
            subject.login(jwtToken);
        } catch(UnknownAccountException e){
            return JSON.toJSONString(new Result().setCode(401).setMessage("账号不存在"));
        }catch (IncorrectCredentialsException e){
            return JSON.toJSONString(new Result().setCode(401).setMessage("密码错误"));
        }
        return JSON.toJSONString(new Result().setCode(200).setMessage("登陆成功"));


    }

    @ApiOperation("手机号登陆")
    @PostMapping("/login/phone")
    public ResponseViewModel<Integer> loginPhone(@RequestBody UserDTO userDTO) {
        log.info("用户登陆 {}", userDTO);

        // TODO 实现登陆

        return ResponseViewModel.ok(1);
    }

    @ApiOperation(value = "用户登出")
    @GetMapping("/logout")
    public ResponseViewModel<Void> logout() {

        // TODO 实现用户登出

        return ResponseViewModel.ok();
    }

    @ApiOperation(value = "用户删除")
    @DeleteMapping("/delete/{userId}")
    public ResponseViewModel<Void> delete(@PathVariable("userId") String userId) {

        // TODO 实现用户删除，并退出系统

        return ResponseViewModel.ok();
    }

    @ApiOperation("用户多条件组合查询接口")
    @PostMapping("/list")
    public ResponseViewModel<List<UserDTO>> listUsers(@RequestBody UserDTO userDTO) {
        List<UserDTO> userDTOList = new ArrayList<>();

        // TODO 实现用户多条件组合查询逻辑

        return ResponseViewModel.ok(userDTOList);
    }


    //测试
    @CrossOrigin
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "你好";
    }
    @CrossOrigin
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(){
        return "我好";
    }
}
