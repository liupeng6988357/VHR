package com.Javaboy.vhr.controller;


import com.Javaboy.vhr.bean.Employee;
import com.Javaboy.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){

        return employeeService.getAllEmployee();
    }

    @RequestMapping(value="/owners/{ownerId}", method=RequestMethod.GET )
    public List<Employee> getEmployeeByParams(@PathVariable String ownerId, Employee model){

        return employeeService.getEmployeeByParams();
    }
}
