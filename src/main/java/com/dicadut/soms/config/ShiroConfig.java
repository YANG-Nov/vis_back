package com.dicadut.soms.config;


import com.dicadut.soms.Realm.MyRealm;
import com.dicadut.soms.shiro.JwtFilter;
import com.dicadut.soms.shiro.MyCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yang
 * @version 1.0.0
 * @create 2021-10-13 11:37
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private MyRealm myRealm;

    @Autowired
    private MyCredentialsMatcher myCredentialsMatcher;


    //安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        myRealm.setCredentialsMatcher(myCredentialsMatcher);
        securityManager.setRealm(myRealm);
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager, JwtFilter jwtFilter) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        Map<String, Filter> map = new HashMap<>();
        map.put("jwt", jwtFilter);
        filterFactoryBean.setFilters(map);
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/swagger-ui.html**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/webjars/**", "anon");
//        filterMap.put("/css/**", "anon");
//        filterMap.put("/js/**", "anon");
//        filterMap.put("/index.html", "anon");
//        filterMap.put("/fonts/**", "anon");
//        filterMap.put("/favicon", "anon");
        filterMap.put("/**", "jwt");
        filterFactoryBean.setLoginUrl("/user/login");
        filterFactoryBean.setUnauthorizedUrl("/user/login");
        filterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return filterFactoryBean;
    }
    //过滤器得放到最后
    @Bean
    public JwtFilter getJwtFilter(){
        return new JwtFilter();
    }
}
