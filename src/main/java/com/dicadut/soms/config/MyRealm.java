package com.dicadut.soms.config;


import com.dicadut.soms.domain.User;
import com.dicadut.soms.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-04-17 13:46
 */
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(MyRealm.class);
    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("entered MyRealm doGetAuthorizationInfo method");
        //获得当前用户
        User user = (User) principals.asList().get(0);
        //需要绑定当前资
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(user.getDuty()+"");
        //authorizationInfo.addStringPermissions(user.getUserPerms());

        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info(">>>entered MyRealm doGetAuthenticationInfo method");
        //获得当前用户
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();
        //获得数据库中的用户，来个当前用户进行比对
        User user = userService.queryUserByName(username);
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
