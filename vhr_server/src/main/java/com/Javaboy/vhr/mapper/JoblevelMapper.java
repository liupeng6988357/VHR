package com.Javaboy.vhr.mapper;

import com.Javaboy.vhr.bean.Joblevel;

import java.util.List;

public interface JoblevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);

    List<Joblevel> getAllJobLevel();
}