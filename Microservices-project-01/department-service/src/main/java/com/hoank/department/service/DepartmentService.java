package com.hoank.department.service;

import com.hoank.department.entity.DepartmentEntity;

public interface DepartmentService {

    DepartmentEntity saveDepartment(DepartmentEntity department);

    DepartmentEntity findDepartmentById(Long departmentId);
}
