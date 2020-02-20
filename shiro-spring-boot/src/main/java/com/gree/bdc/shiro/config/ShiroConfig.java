package com.gree.bdc.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hadoop
 */
@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean:3
     * @param defaultWebSecurityManager 安全管理者
     * @return ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
           anon : 无需认证就可以访问
           authc: 必须认证才可以访问
           user：必须拥有记住我功能才能够访问
           perms: 拥有对某个资源的权限才能访问
           role：拥有某个角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录页
        bean.setLoginUrl("/toLogin");
        return bean;

    }
    /**
     * DefaultWebSecurityManager：2
     * @param userRealm 自定义realm
     * @return securityManager
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //管理userRealm
        securityManager.setRealm(userRealm);
        return securityManager;

    }
    /**
     * 创建realm对象，需要自定义类：1
     * @return 自定义UserRealm
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
