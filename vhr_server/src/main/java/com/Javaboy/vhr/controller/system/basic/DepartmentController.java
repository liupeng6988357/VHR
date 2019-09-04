package com.Javaboy.vhr.controller.system.basic;


import com.Javaboy.vhr.bean.Department;
import com.Javaboy.vhr.bean.RespBean;
import com.Javaboy.vhr.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @DeleteMapping("/")
    public RespBean deleteDepByID(Department department){

        depService.deleteDepById(department);

        if (department.getResult()==1 ){

            return RespBean.ok("部门删除成功");
        } else if (department.getResult()== -2){

            return RespBean.error("该部门下存在子部门，删除失败");
        } else if (department.getResult()== -1){

            return RespBean.error("该部门下存在员工，删除失败");
        }

        return RespBean.error("删除失败");

    }
}
