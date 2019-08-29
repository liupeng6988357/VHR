package com.Javaboy.vhr.mapper;

import com.Javaboy.vhr.bean.Hr_role;

public interface Hr_roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr_role record);

    int insertSelective(Hr_role record);

    Hr_role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr_role record);

    int updateByPrimaryKey(Hr_role record);
}