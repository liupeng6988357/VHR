package com.Javaboy.vhr.mapper;

import com.Javaboy.vhr.bean.Hr;
import com.Javaboy.vhr.bean.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getRoleListByHrId(Integer id);
}