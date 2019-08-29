package com.Javaboy.vhr.mapper;

import com.Javaboy.vhr.bean.Menu_role;

public interface Menu_roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu_role record);

    int insertSelective(Menu_role record);

    Menu_role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu_role record);

    int updateByPrimaryKey(Menu_role record);
}