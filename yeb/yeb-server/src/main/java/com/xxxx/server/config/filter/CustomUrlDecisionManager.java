package com.xxxx.server.config.filter;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.security.auth.login.Configuration;
import java.util.Collection;

/**
 * @ClassName: customUrlDecisionManager
 * @Description: TODO
 * @author: solfeng
 * @date: 2021/7/8  21:37
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
       for (ConfigAttribute configAttribute:configAttributes){
           //访问当前url所需的角色
           String needRole = configAttribute.getAttribute();
           //判断角色是否为登录即可访问的角色,ROLE_LOGIN
           if ("ROLE_LOGIN".equals(needRole)){
               //判断登录
               if (authentication instanceof AnonymousAuthenticationToken){
                   throw new AccessDeniedException("CustomUrlDecisionManager : 尚未登录,请登录!");
               }else {
                   return;
               }
           }
           //判断角色是否为url所需角色
           Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
           for (GrantedAuthority authority : authorities) {
               if (authority.getAuthority().equals(needRole)){
                   return;
               }
           }
       }
        throw new AccessDeniedException("CustomUrlDecisionManager : 权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
