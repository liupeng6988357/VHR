package com.Javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class MyDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws
            AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute: collection
             ) {
            if ("ROLE_HOME".equals(configAttribute.getAttribute())){
               if (authentication instanceof AnonymousAuthenticationToken){
                   throw new AccessDeniedException("访问权限不足，请联系管理员");
               }
            }else{
                return;
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(configAttribute.getAttribute())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("访问权限不足，请联系管理员");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
