package com.Javaboy.vhr.config;


import com.Javaboy.vhr.bean.Menu;
import com.Javaboy.vhr.bean.Role;
import com.Javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Author 刘鹏
 * @Date 2019-09-09
 *
 * 要实现后端的权限管理，至少需要两个步骤：
 *
 * 1.分析当前请求的URL 需要哪些角色？
 *
 * 通过自定义类实现  接口：FilterInvocationSecurityMetadataSource；可以去实现当前请求需要哪些角色
 *
 * 2.判断当前用户是否具备当前请求所需要的角色？
 *
 *
 *
 */
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;


    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 通过这个方法，分析当前请求的URL 所需要的角色
     * @param obj
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {

        /**获取当前请求地址  http://localhost:8080/employee/basic/hello1*/
        String requestUrl = ((FilterInvocation) obj).getRequestUrl();

        List<Menu> allMenuList = menuService.getAllMenus2();

        for (Menu menu:allMenuList) {
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                /**如果匹配成功了*/
                List<Role> roles = menu.getRoles();

                String[] rs = new String[roles.size()];
                for (int i = 0; i < rs.length; i++) {
                    rs[i] = roles.get(i).getName();
                }

                return SecurityConfig.createList(rs);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
