package com.Javaboy.vhr.controller.system.basic;


import com.Javaboy.vhr.bean.Department;
import com.Javaboy.vhr.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/basic/dep")
public class DepartmentController {

    @Autowired
    DepService depService;

    @GetMapping("/")
    public List<Department> getAllDepartment(){
        return depService.getAllDepartment();
    }
}
