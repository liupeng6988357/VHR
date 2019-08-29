package com.Javaboy.vhr.controller;


import com.Javaboy.vhr.bean.Menu;
import com.Javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("/config/allmenus")
    public List<Menu> getAllMenus(){

        return menuService.getAllMenus();
    }
}
