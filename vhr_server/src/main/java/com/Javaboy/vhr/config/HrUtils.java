package com.Javaboy.vhr.config;

import com.Javaboy.vhr.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtils {

    public static Hr getCurrentMenus(){
        /**获取当前登录的对象*/
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
