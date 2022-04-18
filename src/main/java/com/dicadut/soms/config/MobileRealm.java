package com.dicadut.soms.config;


import com.dicadut.soms.domain.User;
import com.dicadut.soms.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-04-18 17:30
 */
@Configuration
public class MobileRealm extends AuthenticatingRealm {
    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(MyRealm.class);
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info(">>>entered MobileRealm doGetAuthenticationInfo method");
        //获得当前用户
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String userName = userToken.getUsername();
        //获得数据库中的用户，来个当前用户进行比对
        User user = userService.queryUserByMobile(userName);
        //国弱没有查到
        if (null == user){
            return null;//会抛出unkownaccountEXCEPTION
        }
        ByteSource salt = ByteSource.Util.bytes("salt");
        //返回authentication完成认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getUserPass(),salt,"myRealm");
        return simpleAuthenticationInfo;
    }
}
