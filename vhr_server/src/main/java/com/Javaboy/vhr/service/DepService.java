package com.Javaboy.vhr.service;


import com.Javaboy.vhr.bean.Department;
import com.Javaboy.vhr.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepService {


    @Autowired
    DepartmentMapper departmentMapper;


    public List<Department> getAllDepartment(){
        return departmentMapper.getAllDepartment(-1);
    }
}
