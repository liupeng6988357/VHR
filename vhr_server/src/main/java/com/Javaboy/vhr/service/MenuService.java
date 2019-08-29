package com.Javaboy.vhr.service;


import com.Javaboy.vhr.bean.Menu;
import com.Javaboy.vhr.config.HrUtils;
import com.Javaboy.vhr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuMapper mennuMapper;

    public List<Menu> getAllMenus() {

        /**根据当前hr的id去查询*/
        return mennuMapper.getAllMenus(HrUtils.getCurrentMenus().getId());
    }

    public List<Menu> getAllMenus2(){
        return mennuMapper.getAllMenus2();
    }
}
