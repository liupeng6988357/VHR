package com.Javaboy.vhr.mapper;

import com.Javaboy.vhr.bean.Sysmsg;

public interface SysmsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sysmsg record);

    int insertSelective(Sysmsg record);

    Sysmsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysmsg record);

    int updateByPrimaryKey(Sysmsg record);
}