package com.dicadut.soms.config;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fan_jennifer
 * @version 1.0
 * @description Jane_TODO
 * @date 2022-04-17 13:43
 */
@Configuration
public class ShiroConfig {
    //1 realm 代表系统资源
    @Bean
    public MyRealm myRealm(){//?????为什么注释掉了
        return new MyRealm();
    }
    //2 securityManager 流程控制
    @Bean
    public DefaultWebSecurityManager mySecurityManager(AuthorizingRealm myRealm, AuthenticatingRealm mobileRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(3);

        myRealm.setCredentialsMatcher(matcher);
        mobileRealm.setCredentialsMatcher(matcher);


        defaultWebSecurityManager.setRealms(Arrays.asList(myRealm,mobileRealm));

        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();//默认
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());//默认
        authenticator.setRealms(Arrays.asList(myRealm,mobileRealm));//默认
        defaultWebSecurityManager.setAuthenticator(authenticator);//默认


        return defaultWebSecurityManager;
    }
    //3 shirofilterfactorybean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager mySecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(mySecurityManager);
        //配置路径过滤器
        Map<String, String> filterMap = new HashMap<>();
        //key 是ant路径，value配置shiro的默认过滤器
        filterMap.put("/task/**","authc,perms[task]");//过滤器是从上往下的perms[]
        filterMap.put("/bridge/**","authc,perms[bridge]");//过滤器是从上往下的perms[]
        filterMap.put("/component/**","authc,perms[component]");//过滤器是从上往下的perms[]
        filterMap.put("/disease/**","authc,perms[disease]");//过滤器是从上往下的perms[]
        filterMap.put("/disease_record/**","authc,perms[disease_record]");//过滤器是从上往下的perms[]
        filterMap.put("/user/**","authc,perms[user]");//过滤器是从上往下的perms[]
        filterMap.put("/dictionary/**","authc,perms[dictionary]");//过滤器是从上往下的perms[]


        //filterMap.put("/common/logout","logout");//也可以登录但是controller没有接口了
        factoryBean.setFilterChainDefinitionMap(filterMap);
        factoryBean.setLoginUrl("/common/failed");//问前端
        factoryBean.setUnauthorizedUrl("/common/unauthorized");


        return factoryBean;
    }
}
