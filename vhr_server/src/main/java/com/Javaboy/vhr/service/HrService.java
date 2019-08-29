package com.Javaboy.vhr.service;

import com.Javaboy.vhr.bean.Hr;
import com.Javaboy.vhr.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Hr hr = hrMapper.loadUserByUsername(s);
        if (hr == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        /**登录之后赋予权限*/
        hr.setRoleList(hrMapper.getRoleListByHrId(hr.getId()));
        return hr;
    }
}
