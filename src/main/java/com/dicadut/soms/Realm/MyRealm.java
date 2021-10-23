package com.dicadut.soms.Realm;

import com.dicadut.soms.entity.User;
import com.dicadut.soms.service.UserService;
import com.dicadut.soms.token.JwtToken;
import com.dicadut.soms.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yang
 * @version 1.0.0
 * @create 2021-10-16 14:32
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JwtToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;
        String jwt = (String) jwtToken.getPrincipal();
        Claims claims = JwtUtil.parseJWT(jwt);
        String username = claims.getId();
        User user = userService.getUserByUsername(username);
        if (user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(username,user.getPassword(),getName());
    }
}
