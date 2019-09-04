package com.Javaboy.vhr.mapper;

import com.Javaboy.vhr.bean.Joblevel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface JoblevelMapper {

    Joblevel getJobLevelByName(String name);

    int addJobLevel(@Param("jobLevel") Joblevel jobLevel);

    List<Joblevel> getAllJobLevels();

    int deleteJobLevelById(@Param("ids") String[] ids);

    int updateJobLevel(@Param("jobLevel") Joblevel jobLevel);

    int addJobLevel(String name, String titleLevel, String createDate, boolean enabled);
}