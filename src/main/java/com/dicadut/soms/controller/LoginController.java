package com.dicadut.soms.controller;



import com.dicadut.soms.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-04-17 13:35
 */
@Api(tags = "登录界面")
@CrossOrigin
@RequestMapping("/common")
@RestController
public class LoginController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);
    @ApiOperation(value = "登录", tags = {"web", "登录页", "jane", "未通"}
            , notes = "用户名:手机号或者小写的姓名全拼，密码:DUT123")
    @PostMapping("/login")
    public Object login(UserVO userVO){
        Map<String, String> errorMsg = new HashMap<>();

        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated() ){
            UsernamePasswordToken token = new UsernamePasswordToken(userVO.getUserName(), userVO.getUserPass());
            try {
                currentUser.login(token);
                currentUser.getSession().setAttribute("currentUser",currentUser.getPrincipal());
                return "login Succeed";
            } catch (UnknownAccountException une){
                log.info("There is no user with username of " + token.getPrincipal());
                errorMsg.put("errorMsg","用户不存在");
            } catch (IncorrectCredentialsException ice){
                log.info("Password for account" + token.getPrincipal() + " was incorrect!");
                errorMsg.put("errorMsg","密码不正确");

            } catch (LockedAccountException lae){
                log.info("The account for username" + token.getPrincipal() + " is locked.");
                errorMsg.put("errorMsg","账户已锁定");

            } catch (AuthenticationException ae){
                errorMsg.put("errorMsg","登录失败");
            }
            return errorMsg;
        }
            return "未授权";


    }
    @ApiOperation(value = "获得当前用户", tags = {"web", "登录页", "jane", "未通"})
    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(){
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        return session.getAttribute("currentUser");


    }

    @ApiOperation(value = "登出", tags = {"web", "登录页", "jane", "未通"})
    @GetMapping("/logout")
    public Object logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "退出登录";
    }

    @ApiIgnore
    @RequestMapping("/unauthorized")
    public Object unauthorized(){
        return "未经授权，无法显示";
    }
}
