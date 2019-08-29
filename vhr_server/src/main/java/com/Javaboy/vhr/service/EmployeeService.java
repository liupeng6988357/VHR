package com.Javaboy.vhr.service;


import com.Javaboy.vhr.bean.Employee;
import com.Javaboy.vhr.config.HrUtils;
import com.Javaboy.vhr.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;


    public List<Employee> getAllEmployee() {

        /**获取全部员工*/
        return employeeMapper.getAllEmployee();
    }

    public List<Employee> getEmployeeByParams() {

        return null;
    }
}
