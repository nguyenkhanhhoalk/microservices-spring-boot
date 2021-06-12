package com.hoank.department.controller;

import com.hoank.department.entity.DepartmentEntity;
import com.hoank.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity departmentEntity){
        log.info("Inside saveDepartment method of DepartmentController");
        return  departmentService.saveDepartment(departmentEntity);
    }

    @GetMapping("/{id}")
    public DepartmentEntity findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById method of DepartmentController");
        return  departmentService.findDepartmentById(departmentId);
    }

}
