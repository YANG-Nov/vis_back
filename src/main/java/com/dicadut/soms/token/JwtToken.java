package com.dicadut.soms.token;

import lombok.Data;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * @author Yang
 * @version 1.0.0
 * @create 2021-10-16 19:02
 */
@Data
@Component
public class JwtToken implements HostAuthenticationToken, RememberMeAuthenticationToken {
    private String token;
    private char[] password;
    private boolean rememberMe = false;
    private String host;

    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
