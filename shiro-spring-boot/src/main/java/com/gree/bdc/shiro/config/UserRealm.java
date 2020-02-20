package com.gree.bdc.shiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义用户安全数据源
 * @author hadoop
 */
public class UserRealm extends AuthorizingRealm {
    /**
     * 授权
     * @param principalCollection 未知
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("调用了授权方法");
        return null;
    }

    /**
     * 认证
     * @param authenticationToken 令牌
     * @return 认证信息
     * @throws AuthenticationException 认证失败异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("调用了认证方法");
        //从数据库中取用户名，密码

        //本地测试
        String name = "root";
        String password = "123456";
        UsernamePasswordToken userToken =(UsernamePasswordToken)  authenticationToken;
        if (!userToken.getUsername().equals(name)){
            //抛出未知用户异常
            return null;
        }
        return new SimpleAuthenticationInfo("",password,"");
    }
}
