package com.hoank.department.service.impl;


import com.hoank.department.entity.DepartmentEntity;
import com.hoank.department.repository.DepartmentRepository;
import com.hoank.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity department) {
        log.info("Inside saveDepartment of DepartmentServiceImpl");
        return departmentRepository.save(department);
    }

    @Override
    public DepartmentEntity findDepartmentById(Long departmentId) {
        log.info("Inside saveDepartment of DepartmentServiceImpl");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
