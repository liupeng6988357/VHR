package com.Javaboy.vhr.controller.system.basic;


import com.Javaboy.vhr.bean.Joblevel;
import com.Javaboy.vhr.bean.RespBean;
import com.Javaboy.vhr.service.JobLevelService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/jobLevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/addJobLevel/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
        int result = jobLevelService.addJobLevel(joblevel);

        if (result == 1) {
            return RespBean.ok("添加成功!");
        } else if (result == -1) {
            return RespBean.error("职称名重复，添加失败!");
        }
        return RespBean.error("添加失败!");
    }
}
