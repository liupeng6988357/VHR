package com.Javaboy.vhr.mapper;

import com.Javaboy.vhr.bean.Empsalary;

public interface EmpsalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Empsalary record);

    int insertSelective(Empsalary record);

    Empsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empsalary record);

    int updateByPrimaryKey(Empsalary record);
}