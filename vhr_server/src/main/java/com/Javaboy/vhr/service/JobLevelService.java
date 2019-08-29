package com.Javaboy.vhr.service;


import com.Javaboy.vhr.bean.Joblevel;
import com.Javaboy.vhr.mapper.JoblevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelService {

    @Autowired
    JoblevelMapper joblevelMapper;

    public List<Joblevel> getAllJobLevel() {

        return joblevelMapper.getAllJobLevel();
    }
}
