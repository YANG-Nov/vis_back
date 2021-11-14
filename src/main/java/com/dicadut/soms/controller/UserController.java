package com.dicadut.soms.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dicadut.soms.common.ResponseViewModel;
import com.dicadut.soms.dto.UserDTO;
import com.dicadut.soms.entity.User;
import com.dicadut.soms.dto.UserStatusDTO;
import com.dicadut.soms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseViewModel<String> loginUserName(@RequestBody UserDTO userDTO) {
        log.info("用户登陆 {}", userDTO);

        ResponseViewModel<UserDTO> responseViewModel = new ResponseViewModel<>();
        User user = new User();
        BeanUtil.copyProperties(userDTO, user);

        User one = userService.getOne(new QueryWrapper<User>()
                .eq("username", user.getUsername())
                .eq("password", user.getPassword())
        );
        if(one!=null){
            return ResponseViewModel.ok("success");
        }else {
            return ResponseViewModel.ok("fail");
        }


    }

    @ApiOperation("手机号登陆")
    @PostMapping("/login/phone")
    public ResponseViewModel<String> loginPhone(@RequestBody UserDTO userDTO) {
        log.info("用户登陆 {}", userDTO);

        ResponseViewModel<UserDTO> responseViewModel = new ResponseViewModel<>();
        User user = new User();
        BeanUtil.copyProperties(userDTO, user);

        User one = userService.getOne(new QueryWrapper<User>()
                .eq("phone", user.getPhone())
                .eq("password", user.getPassword())
        );
        if(one!=null){
            return ResponseViewModel.ok("success");
        }else {
            return ResponseViewModel.ok("fail");
        }

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

    @ApiOperation("巡检员工作状态")
    @PostMapping("/status/inspector")
    public ResponseViewModel<Long> statusInspector(@RequestBody UserStatusDTO userStatusDTO) {
        Page<User> pageUser = new Page<>();
        //构建条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //多条件组合查询
        Integer duty = userStatusDTO.getDuty();
        Integer status = userStatusDTO.getStatus();
        //判断条件值是否为空，如果不为空拼接条件
        if(!ObjectUtils.isEmpty(duty)) {
            wrapper.eq("duty", 2);
        }
        if(!ObjectUtils.isEmpty(status)){
            wrapper.eq("status",1);
        }
        userService.page(pageUser, wrapper);
        long total = pageUser.getTotal();//总数
        return ResponseViewModel.ok(total);
    }

    @ApiOperation("维修员工作状态")
    @PostMapping("/status/maintainer")
    public ResponseViewModel<List<UserStatusDTO>> statusMaintainer(@RequestBody UserStatusDTO userStatusDTO) {
        List<UserStatusDTO> statusMaintainerList = userService.getStatusMaintainerList();
        return ResponseViewModel.ok(statusMaintainerList);
        /*

        Page<User> pageUser = new Page<>();
        //构建条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //多条件组合查询
        Integer duty = userStatus.getDuty();
        Integer status = userStatus.getStatus();
        //判断条件值是否为空，如果不为空拼接条件
        if(!ObjectUtils.isEmpty(duty)) {
            wrapper.eq("duty", 3);
        }
        if(!ObjectUtils.isEmpty(status)){
            wrapper.eq("status",1);
        }
        userService.page(pageUser, wrapper);
        long total = pageUser.getTotal();//总数
        return ResponseViewModel.ok(total);*/

    }


    }

