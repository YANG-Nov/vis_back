package com.dicadut.soms.shiro;

import com.dicadut.soms.entity.User;
import com.dicadut.soms.service.UserService;
import com.dicadut.soms.token.JwtToken;
import com.dicadut.soms.util.StringUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yang
 * @version 1.0.0
 * @create 2021-10-23 14:25
 */
@Component
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private UserService userService;
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        JwtToken jwtToken = (JwtToken) token;
        if (jwtToken.getPassword() == null){
            return true;
        }
        String inPassword = new String(jwtToken.getPassword());
        String username = String.valueOf(info.getPrincipals());
        String dbPassword = (String) info.getCredentials();
        User user = userService.getUserByUsername(username);
        String salt = user.getSalt();

        return this.equals(StringUtil.md5(inPassword + salt),dbPassword);
    }

}
