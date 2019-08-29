package com.Javaboy.vhr.controller.system.basic;


import com.Javaboy.vhr.bean.Joblevel;
import com.Javaboy.vhr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<Joblevel> getAllJobLevel(){
        return jobLevelService.getAllJobLevel();
    }
}
