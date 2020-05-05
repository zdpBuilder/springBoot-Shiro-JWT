package com.zdp.jwt.framework.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author zdp
 * @description: Token 认证令牌
 */
public class JWTToken implements AuthenticationToken {

    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
